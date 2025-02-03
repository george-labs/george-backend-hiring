import data.Word
import java.io.File
import java.io.FileNotFoundException
import java.io.InputStream

fun main(vararg args: String) {
    val counter = WordCounter()
    val stopWords = getWordsListFromFile("stopwords.txt", isStopWords = true)

    val words = if (args.isNotEmpty() && args.get(0) != "-index") {
        getWordsListFromFile(args.get(0), isStopWords = false)
    } else {
        print("Enter text: ")
        readln().splitToWords()
    }

    println(
        "Number of words: ${counter.countWords(words, stopWords)}" +
                ", unique: ${counter.countUniqueWords(words, stopWords)}" +
                "; average word length: ${counter.averageWordLength(words, stopWords)} characters"
    )
    if (args.isNotEmpty() && args.contains("-index")) {
        val filteredWords = counter.filterWords(words, stopWords).map { it.value }.toMutableList()
        if (filteredWords.isNotEmpty()) {
            println("Index:")
            filteredWords.sort()
            filteredWords.map { println(it) }
        }
    }
}

fun getWordsListFromFile(filename: String, isStopWords: Boolean = false): List<Word> {
    try {
        val inputStream: InputStream = File(filename).inputStream()
        val lineList = mutableListOf<String>()

        inputStream.bufferedReader().forEachLine { lineList.add(it) }
        return lineList.flatMap { it.splitToWords() }
    } catch (e: FileNotFoundException) {
        println("Failed to open ${if (isStopWords) "stop " else ""}words file")
        print("Enter text: ")
        return readln().splitToWords()
    }
}