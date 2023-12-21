import java.io.File

const val STOP_WORDS_FILE = "stopwords.txt"

fun readStopWordsFromFile(fileName: String = STOP_WORDS_FILE): List<String> {
    val stopWords = mutableListOf<String>()
    File(fileName).forEachLine { stopWords.add(it) }
    return stopWords
}

fun countWords(text: String, stopWords: List<String> = emptyList()): Int {
    return text.split(" ").filter { word -> word.isNotEmpty() }.filter { word -> !stopWords.contains(word)  }.filter { word -> word.all { it.isLetter() } }.size
}

fun main(args: Array<String>) {
    print("Enter text: ")
    val text = readln()
    val stopWords = readStopWordsFromFile()
    val numOfWords = countWords(text,  stopWords)
    println("Number of words: $numOfWords")
}
