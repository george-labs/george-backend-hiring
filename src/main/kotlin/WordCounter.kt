class WordCounter {

    private val wordRegex = "^[a-zA-Z]+\$".toRegex()

    fun count(word: String): Int {
        val words = word.split(" ")
        return words.count { wordRegex.matches(it) }
    }
}