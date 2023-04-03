import java.io.File
import java.io.InputStreamReader
import java.math.BigDecimal

fun main(args: Array<String>) {
    val stopWords = readStopWordsFromClasspath()
    val counter = WordCounter(stopWords)

    val inputLine = if (args.isEmpty()) {
        readFromStdin()
    } else {
        readFromFile(args)
    }
    val indexEnabled = indexEnabled(args)

    val result = counter.countWords(inputLine)

    println("Number of words: ${result.totalCount}, unique: ${result.uniqueWords.size}, average word length: ${formatAverage(result.averageWordLength)}")
    if (indexEnabled) {
        println("Index:")
        result.wordIndex().forEach { println(it) }
    }
}

fun indexEnabled(args: Array<String>): Boolean = args.lastOrNull() == Params.INDEX

fun formatAverage(averageLength: BigDecimal?): String = averageLength?.let { "$it characters" } ?: "N/A"

private fun readStopWordsFromClasspath(): Set<String> {
    val resourcePath = WordCounter::class.java.getResource("stopwords.txt") ?: error("Resource not found")
    val stopWords = resourcePath.openStream().use { inputStream ->
        InputStreamReader(inputStream).use { reader -> reader.readLines() }
    }.toSet()
    return stopWords
}

private fun readFromFile(args: Array<String>) = File(args.first()).readText()

private fun readFromStdin(): String {
    print("Enter text: ")
    return readln()
}

object Params {
    const val INDEX = "-index"
}
