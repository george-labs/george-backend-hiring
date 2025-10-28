class WordCounter(val stopWords: Set<String>) {
    var wordsList = listOf<String>()

    fun setInputText (text: String) {
        wordsList = getWords(text, stopWords)
    }

    fun countAllWords(): Int {
        return wordsList.count()
    }

    fun countUniqueWords(): Int {
        return wordsList.toSet().count()
    }

    private fun getWords(text: String, stopWords: Set<String>): List<String> {
        return Regex("[A-Za-z]+")
            .findAll(text)
            .map { it.value.lowercase() }
            .filter { it.isNotBlank() && it !in stopWords }
            .toList()
    }
}
