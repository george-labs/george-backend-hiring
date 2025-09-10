class WordCounter(private val stopwords: List<String>) {
    fun countWords(words: List<String>): Int {
        return words.filterNot { stopwords.contains(it.lowercase()) }.size
    }
}