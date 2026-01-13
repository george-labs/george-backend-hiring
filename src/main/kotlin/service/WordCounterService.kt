package service

import model.WordCounterResult

private val WORD_REGEX_PATTERN = "[a-zA-Z]+".toRegex()

class WordCounterService(
    val stopWords: List<String> = emptyList(),
) {
    fun countWords(text: String): WordCounterResult {
        val filteredWords = splitWords(text)
            .filterWithStopWords()
        return WordCounterResult(
            totalWords = filteredWords.size,
            uniqueWords = filteredWords.distinct().size,
        )
    }

    private fun splitWords(text: String): List<String> {
        return WORD_REGEX_PATTERN.findAll(text).map { it.value }.toList()
    }

    private fun List<String>.filterWithStopWords(): List<String> {
        return takeIf { stopWords.isEmpty() } ?: filterNot { it in stopWords }
    }
}