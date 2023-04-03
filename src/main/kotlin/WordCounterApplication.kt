import java.io.InputStreamReader
import java.io.Reader
import java.nio.file.Files
import java.nio.file.Path

fun main(args: Array<String>) {
    val stopWords = WordCounter::class.java.getResource("stopwords.txt")!!.openStream().use { inputStream ->
        InputStreamReader(inputStream).use { reader -> reader.readLines() }
    }.toSet()

    val counter = WordCounter(stopWords)

    print("Enter text: ")

    val inputLine = readln()
    val count = counter.countWords(inputLine)

    println("Number of words: $count")

}
