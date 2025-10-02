class WordCounter(stopWordsReader: ResourceReader) {

    private val wordRegex = "^[a-zA-Z]+[.]?\$".toRegex()
    private val stopWords = stopWordsReader.provide().map { it.lowercase() }

    private fun filterWords(words: List<String>): List<String> {
        return words.filter { !stopWords.contains(it.lowercase()) }
    }

    private fun matchWordsWithRegex(words: List<String>): List<String> {
        return words.filter { wordRegex.matches(it) }
    }

    private fun splitWords(wordsJoined: String): List<String> {
        return wordsJoined.split("[\\s-]".toRegex())
    }

    private fun uniqueWords(words: List<String>): Set<String> {
        return words.toSet()
    }

    fun count(wordsJoined: String): Words {
        val words = splitWords(wordsJoined)
        val filterWords = filterWords(words)
        val matchedFilteredWords = matchWordsWithRegex(filterWords)
        val uniqueFilteredMatchedWords = uniqueWords(matchedFilteredWords)
        return Words(
            filteredCount = matchedFilteredWords.size,
            uniqueFilteredCount = uniqueFilteredMatchedWords.size
        )
    }
}

data class Words(val filteredCount: Int, val uniqueFilteredCount: Int)