import iteration1.WordCounter
import java.io.File


/**
 * This method is the entry point of the program. It analyzes a given sentence or a file's content
 * using the WordCounter class and outputs the number of words, number of unique words,
 * and the average word length.
 *
 * @param args the command line arguments. The first argument can be a file name to read the content from.
 */
fun main(args: Array<String>) {
    val wordCounter = WordCounter()

    if(args.isNotEmpty()) {
        val filename = args[0]
        val contents: String? = readFileContents(filename)

        contents?.let {
            printOutput(wordCounter.countWords(it), wordCounter.countUniqueWords(it), wordCounter.countAverageWordLength(it))
        } ?: run {
            println("Unable to read file $filename")
        }
    } else {
        print("Enter text:")

        val content = readlnOrNull()

        printOutput(wordCounter.countWords(content), wordCounter.countUniqueWords(content), wordCounter.countAverageWordLength(content))
    }
}

fun readFileContents(filename: String): String? {
    return try {
        val lines = File(filename).readLines()

        lines.joinToString(" ")
    } catch (e:Exception) {
        null
    }
}

fun printOutput(number: Int, unique:Int, average:Double) {
    println("Number of words: $number, unique: $unique; average word length: $average")
}
