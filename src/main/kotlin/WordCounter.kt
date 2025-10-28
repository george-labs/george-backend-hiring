import java.io.File

class WordCounter(val fileReader: FileReader) {
    fun getStopWords(): Set<String> {
        val stopWordsContent = fileReader.readFile("src/main/resources/stopwords.txt")
        return stopWordsContent.split("\n").map { it.trim() }.toSet()
    }

    fun countWords(text: String): Int {
        return Regex("[A-Za-z]+")
            .findAll(text)
            .map { it.value.lowercase() }
            .filter { it.isNotBlank() && it !in getStopWords() }
            .count()
    }
}


