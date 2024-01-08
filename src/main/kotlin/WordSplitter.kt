interface WordSplitter {

    // TODO: delimiters could be added
    fun split(words: String, wordsToIgnore: List<String> = emptyList()): List<String>
}