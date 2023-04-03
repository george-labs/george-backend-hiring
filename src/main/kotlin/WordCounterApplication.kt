import java.io.File
import java.io.FileNotFoundException
import java.io.InputStreamReader
import java.math.BigDecimal

fun main(args: Array<String>) {
    val stopWords = readStopWordsFromClasspath()
    val counter = WordCounter(stopWords)

    try {
        val indexEnabled = indexEnabled(args)
        val inputLine = when {
            args.isEmpty()  -> readFromStdin()
            args.size == 1 && indexEnabled  -> readFromStdin()
            else -> readFromFile(args)
        }

        val result = counter.countWords(inputLine)

        println("Number of words: ${result.totalCount}, unique: ${result.uniqueWords.size}, average word length: ${formatAverage(result.averageWordLength)}")
        if (indexEnabled) {
            println("Index:")
            result.wordIndex().forEach { println(it) }
        }
    } catch (e: WordCountException) {
        println(e.message)
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

private fun readFromFile(args: Array<String>): String {
    val filename = args.first()
    return runCatching {
        File(filename).readText()
    }
        .onFailure { throw WordCountException("Cannot read input file $filename") }
        .getOrThrow()
}

private fun readFromStdin(): String {
    print("Enter text: ")
    return readln()
}

object Params {
    const val INDEX = "-index"
}

class WordCountException(message: String) : RuntimeException(message)
