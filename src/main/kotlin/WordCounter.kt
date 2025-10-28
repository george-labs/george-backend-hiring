class WordCounter(val fileReader: FileReader) {
    fun getStopWords(): Set<String> {
        val stopWordsContent = fileReader.readFile("src/main/resources/stopwords.txt")
        return stopWordsContent.split("\n").map { it.trim() }.toSet()
    }

    fun getWords(text: String): List<String> {
        return Regex("[A-Za-z]+")
            .findAll(text)
            .map { it.value.lowercase() }
            .filter { it.isNotBlank() && it !in getStopWords() }
            .toList()
    }

    fun countAllWords(list: List<String>): Int {
        return list.count()
    }

    fun countUniqueWords(list: List<String>): Int {
        return list.toSet().count()
    }
}


