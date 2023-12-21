import java.io.File

const val STOP_WORDS_FILE = "stopwords.txt"

fun checkFileExists(fileName: String): Boolean {
    if (!File(fileName).exists()) {
        println("A file $fileName not found. It should be located at ${System.getProperty("user.dir")}")
        return false
    }
    return true
}

fun readStopWordsFromFile(fileName: String = STOP_WORDS_FILE): Set<String> {
    if (!checkFileExists(fileName)) {
        println("Assuming no stop words exist")
        return emptySet()
    }
    val stopWords = mutableSetOf<String>()
    File(fileName).forEachLine { stopWords.add(it) }
    return stopWords
}

fun countWords(text: String, stopWords: Set<String> = emptySet()): Int {
    return text.split(" ").filter { word -> word.isNotEmpty() }.filter { word -> !stopWords.contains(word) }
        .filter { word -> word.all { it.isLetter() } }.size
}

fun readTextFromFile(fileName: String): String {
    val text = StringBuilder()
    File(fileName).forEachLine { text.append(it) }
    return text.toString()
}

fun getTextInput(fileName: String? = null): String {
    var text: String
    if (!fileName.isNullOrEmpty() && checkFileExists(fileName)) {
        text = readTextFromFile(fileName)
    } else {
        print("Enter text: ")
        text = readln()
    }
    return text
}

fun main(args: Array<String>) {
    val text = getTextInput(args.firstOrNull())
    val stopWords = readStopWordsFromFile()
    val numOfWords = countWords(text, stopWords)
    println("Number of words: $numOfWords")
}
