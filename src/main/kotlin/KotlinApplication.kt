import data.Word
import java.io.File
import java.io.InputStream

fun main() {
    print("Enter text: ")
    val words = readln()
    val stopWords = getStopWordsListFromFile("stopwords.txt")
    val counter = WordCounter(words)
    println(stopWords)
    println("Number of words: ${counter.countWords(counter.splitToWords(), stopWords)}")
}

fun getStopWordsListFromFile(filename: String): List<Word> {
    val inputStream: InputStream = File(filename).inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().forEachLine { lineList.add(it) }
    return lineList.map { Word(it) }
}