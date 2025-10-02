class WordCounter(stopWordsReader: ResourceReader) {

    private val wordRegex = "^[a-zA-Z]+\$".toRegex()
    private val stopWords = stopWordsReader.provide().map { it.lowercase() }

    private fun filterWords(words : List<String>) : List<String> {
        return words.filter { !stopWords.contains(it.lowercase()) }
    }

    private fun splitWords(wordsJoined: String): List<String> {
        return wordsJoined.split(" ")
    }

    fun count(wordsJoined: String): Int {
        val words = splitWords(wordsJoined)
        val filterWords = filterWords(words)
        return filterWords.count { wordRegex.matches(it) }
    }
}