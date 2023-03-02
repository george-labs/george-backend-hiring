import java.io.File
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.system.exitProcess

const val STOP_WORD_FILENAME = "stopwords.txt"
const val ROUND_PLACES = 2

/**
 * a word starts with 1 or more letters
 * a word can be multiple sequences of characters connected by a single hyphen
 */
val WORD_REGEX = Regex("[A-Za-z]+(?:-[A-Za-z]+)*")

fun getWords(text: String, stopWords: List<String>) =
    generateSequence(WORD_REGEX.find(text)) { it.next() }
            .map { it.value }
            .filter { !stopWords.contains(it) }
            .toList()

fun readStopWords() =
    File(STOP_WORD_FILENAME).useLines { it.toList() }

fun readInputFromFile(filename: String) =
    File(filename).useLines { it.toList() }.joinToString(" ")

fun askUserForInput(): String {
    print("Enter text: ")
    return readln()
}

fun handleWrongArguments(): Nothing {
    System.err.println("Usage: No argument or 1 argument with input filename")
    exitProcess(1)
}

/**
 * Only works for non-empty list
 */
fun averageLength(words: List<String>) =
   BigDecimal(words.map { it.length }.average()).setScale(ROUND_PLACES, RoundingMode.HALF_UP)

fun reportWordCounts(words: List<String>) =
    WordCountReport(
            totalCount = words.count(),
            uniqueCount = words.distinct().count(),
            averageWordLength = if (words.isEmpty()) null else averageLength(words))

fun formatOptionalNumber(number: BigDecimal?) =
        number?.toString() ?: "N/A"

fun main(args: Array<String>) {
    val stopWords = readStopWords()
    val inputString = when (args.size) {
        0 -> askUserForInput()
        1 -> readInputFromFile(args[0])
        else -> handleWrongArguments()
    }
    val wordCountReport = reportWordCounts(getWords(inputString, stopWords))
    println(wordCountReport)
}