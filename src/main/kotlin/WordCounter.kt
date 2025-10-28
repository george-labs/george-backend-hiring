import java.io.File

fun readFile(filePath: String): String {
    val file = File(filePath).readText()
    return file
}

fun getStopWords(): Set<String> {
    val stopWordsContent = readFile("src/main/resources/stopwords.txt")
    return stopWordsContent.split("\n").map { it.trim() }.toSet()
}

fun countWords(text: String): Int {
    return Regex("[A-Za-z]+")
        .findAll(text)
        .map { it.value.lowercase() }
        .filter { it.isNotBlank() && it !in getStopWords() }
        .count()
}