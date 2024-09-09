import iteration1.WordCounter
import java.io.File

const val STOPWORDS_FILE = "/stopwords.txt"

/**
 * This method is the entry point of the program. It analyzes a given sentence or a file's content
 * using the WordCounter class and outputs the number of words, number of unique words,
 * and the average word length.
 *
 * @param args the command line arguments. The first argument can be a file name to read the content from.
 */
fun main(args: Array<String>) {

    val printIndex = args.contains("-index")

    val wordCounter = parseDictionaryFile(args)?.let {
        WordCounter(tokenizeLines(readResource(STOPWORDS_FILE)),tokenizeLines(readFileContents(it)))
    } ?: WordCounter(tokenizeLines(readResource(STOPWORDS_FILE) ))

    val fileName = parseFileName(args)

    if(!fileName.isNullOrEmpty()) {
        val contents: String? = readFileContents(fileName)

        contents?.let {
            printOutput(if (printIndex) wordCounter.getMarkedWords(it) else null, wordCounter.countWords(it), wordCounter.countUniqueWords(it), wordCounter.countAverageWordLength(it))
        } ?: run {
            println("Unable to read file $fileName")
        }
    } else {
        print("Enter text:")

        val content = readlnOrNull()

        printOutput(if (printIndex) wordCounter.getMarkedWords(content) else null, wordCounter.countWords(content), wordCounter.countUniqueWords(content), wordCounter.countAverageWordLength(content))
    }
}

fun readFileContents(filename: String): String? {
    return try {
        val lines = File(filename).readLines()

        lines.joinToString("\n")
    } catch (e:Exception) {
        null
    }
}

// TODO: Add multiple version of this that work so that no printing logic is encapsulated in this function.
fun printOutput(words:List<String>?, number: Int, unique:Int, average:Double) {
    println("Number of words: $number, unique: $unique; average word length: $average")
    if(!words.isNullOrEmpty()) {
        println("Index (unknown: ${words.count { !it.endsWith("*") }}):")
        words.forEach {
            println(it)
        }
    }
}

fun tokenizeLines(text: String?): Set<String> {
    val stopWords = mutableSetOf<String>()

    text?.split("\n")?.map { it.trim().lowercase() }?.forEach(stopWords::add)

    return stopWords.toSet()
}

fun parseFileName(args: Array<String>): String? {
    val strings = args.filter { !it.startsWith("-") }

    return if (strings.size == 1) strings[0] else null
}

fun parseDictionaryFile(args: Array<String>): String? {
    return args.filter { it.startsWith("-dictionary=") }.map { it.substringAfter("-dictionary=") }.firstOrNull()
}

fun readResource(name: String): String? {
    return object {}.javaClass.getResource(name)?.readText()
}
// TODO: Move thing out from processing in constructor. The values of regex, stopWords and dictWords should be provided to this class.
/*
init {



    val dictText = object {}.javaClass.getResource("/dict.txt")?.readText()
    dictText?.split("\n")?.map { it.trim().lowercase() }?.forEach(dictWords::add)
}
*/
