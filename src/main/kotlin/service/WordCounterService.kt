package service

private val WORD_REGEX_PATTERN = "[a-zA-Z]+".toRegex()

class WordCounterService(
    val stopWords: List<String> = emptyList(),
) {
    fun countWords(text: String): Int {
        return splitWords(text)
            .filterWithStopWords()
            .size
    }

    private fun splitWords(text: String): List<String> {
        return WORD_REGEX_PATTERN.findAll(text).map { it.value }.toList()
    }

    private fun List<String>.filterWithStopWords(): List<String> {
        return takeIf { stopWords.isEmpty() } ?: filterNot { it in stopWords }
    }
}