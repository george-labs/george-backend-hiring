class WordCounter(private val stopwords: List<String>) {
    fun countWords(words: List<String>): Int {
        return words.filterStopWords().size
    }

    fun countUniqueWords(words: List<String>): Int {
        return words.filterStopWords().toSet().size
    }

    fun calculateAverageWordLength(words: List<String>): Double {
        val filteredWords = words.filterStopWords()
        if (filteredWords.isEmpty()) return 0.0
        val wordsCount = filteredWords.size.toDouble()
        val totalLength = filteredWords.sumOf { it.length }
        return totalLength / wordsCount
    }

    private fun List<String>.filterStopWords(): List<String> =
        filterNot { stopwords.contains(it.lowercase()) }
}