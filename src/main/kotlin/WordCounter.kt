class WordCounter {

    fun count(words: String): Int {
        return words.split(" ").filter { it.matches("[a-zA-Z]+".toRegex()) }.size
    }
}