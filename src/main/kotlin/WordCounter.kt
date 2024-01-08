interface WordCounter {
    fun count(words: String, wordsToIgnore: List<String> = emptyList()): List<String>
}