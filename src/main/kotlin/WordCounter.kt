class WordCounter(private val stopwords: List<String>) {
    fun countWords(words: List<String>): Int {
        return words.filterStopWords().size
    }

    fun countUniqueWords(words: List<String>): Int {
        return words.filterStopWords().toSet().size
    }

    private fun List<String>.filterStopWords(): List<String> =
        filterNot { stopwords.contains(it.lowercase()) }
}