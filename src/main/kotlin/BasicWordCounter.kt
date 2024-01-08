class BasicWordCounter : WordCounter {

    override fun count(words: String, wordsToIgnore: List<String>): Int {
        return words
            .split(" ")
            .filter { it.matches("[a-zA-Z]+".toRegex()) }
            .filterNot { it in wordsToIgnore }
            .size
    }
}