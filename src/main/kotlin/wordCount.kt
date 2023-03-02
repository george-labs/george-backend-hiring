import java.io.File

const val STOP_WORD_FILENAME = "stopwords.txt"

/**
 * Returns the number of words in the text,
 * words hve to be separated by one or more " " (space) characters,
 * a sequence of characters containing anything else except a-z and A-Z is not a word and thus ignored
 */
fun countWords(text: String, stopWords: List<String>) =
    text.split(Regex(" +"))
            .filter { it.matches(Regex("[A-Za-z]+")) }
            .filter { !stopWords.contains(it) }
            .count()

fun readStopWords() =
    File(STOP_WORD_FILENAME).useLines { it.toList() }

fun readInputFromFile(filename: String) =
    File(filename).useLines { it.toList() }.joinToString(" ")

fun askUserForInput(): String {
    print("Enter text: ")
    return readln()
}

fun handleWrongArguments() {
    System.err.println("Usage: No argument or 1 argument with input filename")
    System.exit(1)
}

fun main(args: Array<String>) {
    val stopWords = readStopWords()
    when (args.size) {
        0 -> askUserForInput()
        1 -> readInputFromFile(args[0])
        else -> handleWrongArguments()
    }
    val count = countWords(readln(), stopWords)
    println("Number of words: $count")
}