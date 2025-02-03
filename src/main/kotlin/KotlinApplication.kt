import data.Word
import java.io.File
import java.io.InputStream

fun main(vararg args: String) {
    val words = if (args.isNotEmpty()) {
        getWordsListFromFile(args.get(0))
    } else {
        print("Enter text: ")
        readln().splitToWords()
    }
    val stopWords = getWordsListFromFile("stopwords.txt")
    val counter = WordCounter()
    println("Number of words: ${counter.countWords(words, stopWords)}")
}

fun getWordsListFromFile(filename: String): List<Word> {
    val inputStream: InputStream = File(filename).inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().forEachLine { lineList.add(it) }
    return lineList.flatMap { it.splitToWords() }
}