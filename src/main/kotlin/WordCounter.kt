class WordCounter {

    fun count(words: String, wordsToIgnore: List<String> = emptyList()): Int {
        return words
            .split(" ")
            .filter { it.matches("[a-zA-Z]+".toRegex()) }
            .filterNot { it in wordsToIgnore }
            .size
    }
}