import java.io.File

const val STOP_WORDS_FILE = "stopwords.txt"

fun checkStopWordsFileExists(fileName: String): Boolean {
    if (!File(fileName).exists()) {
        println("Stop words file $fileName not found. Assuming no stop words exist")
        println("If you want to use stop words, please create a file $fileName at ${System.getProperty("user.dir")} with one stop word per line")
        return false
    }
    return true
}

fun readStopWordsFromFile(fileName: String = STOP_WORDS_FILE): Set<String> {
    if(!checkStopWordsFileExists(fileName)) {
        return emptySet()
    }
    val stopWords = mutableSetOf<String>()
    File(fileName).forEachLine { stopWords.add(it) }
    return stopWords
}

fun countWords(text: String, stopWords: Set<String> = emptySet()): Int {
    return text.split(" ").filter { word -> word.isNotEmpty() }.filter { word -> !stopWords.contains(word)  }.filter { word -> word.all { it.isLetter() } }.size
}

fun main(args: Array<String>) {
    print("Enter text: ")
    val text = readln()
    val stopWords = readStopWordsFromFile()
    val numOfWords = countWords(text,  stopWords)
    println("Number of words: $numOfWords")
}
