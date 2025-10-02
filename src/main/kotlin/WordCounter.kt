class WordCounter(stopWordsReader: ResourceReader) {

    private val wordRegex = "^[a-zA-Z]+-?[a-zA-Z]+[.]?$".toRegex()
    private val stopWords = stopWordsReader.provide().map { it.lowercase() }

    private fun filterWords(words: List<String>): List<String> {
        return words.filter { !stopWords.contains(it.lowercase()) }
    }

    private fun matchWordsWithRegex(words: List<String>): List<String> {
        return words.filter { wordRegex.matches(it) }
    }

    private fun splitWords(wordsJoined: String): List<String> {
        return wordsJoined.split("\\s".toRegex())
    }

    private fun uniqueWords(words: List<String>): Set<String> {
        return words.toSet()
    }

    fun count(wordsJoined: String): Words {
        val words = splitWords(wordsJoined)
        val matchedFilteredWords = matchWordsWithRegex(filterWords(words))
        val uniqueFilteredMatchedWords = uniqueWords(matchedFilteredWords)
        val avgWordLength = avgWordLength(matchedFilteredWords)
        return Words(
            filteredCount = matchedFilteredWords.size,
            uniqueFilteredCount = uniqueFilteredMatchedWords.size,
            avgWordLength = avgWordLength
        )
    }

    private fun avgWordLength(words: List<String>): Double {
        val wordSize = words.size.toDouble()
        val stringLength = words.joinToString("").length.toDouble()
        return (stringLength / wordSize)
    }
}

data class Words(val filteredCount: Int, val uniqueFilteredCount: Int, val avgWordLength: Double)