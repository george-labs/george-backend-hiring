import java.io.File
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val stopWords = readStopWordsFromClasspath()
    val counter = WordCounter(stopWords)

    val inputLine = if (args.isEmpty()) {
        readFromStdin()
    } else {
        readFromFile(args)
    }

    val (total, unique) = counter.countWords(inputLine)

    println("Number of words: $total, unique: $unique")
}

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
