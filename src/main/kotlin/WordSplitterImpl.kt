class WordSplitterImpl : WordSplitter {

    override fun split(words: String, wordsToIgnore: List<String>): List<String> {
        val normalizedWords = words.replace("[.,]+".toRegex(), "")
        return normalizedWords
            .split(" ", "-")
            .filter { it.matches("[a-zA-Z]+".toRegex()) }
            .filterNot { it in wordsToIgnore }
    }
}