package service

import model.WordCounterResult

private val WORD_REGEX_PATTERN = "[a-zA-Z]+(-[a-zA-Z]+)*".toRegex()

class WordCounterService(
    val stopWords: List<String> = emptyList(),
    val indexed: Boolean = false,
) {
    fun countWords(text: String): WordCounterResult {
        val filteredWords = splitWords(text)
            .filterWithStopWords()
        val uniqueWords = filteredWords.distinct()
        return WordCounterResult.Companion.Builder()
            .totalWords(filteredWords.size)
            .uniqueWords(uniqueWords.size)
            .averageWordsLength(calculateAverageWordLength(filteredWords))
            .addIndexedWordsIfNeeded(uniqueWords)
            .build()
    }

    private fun calculateAverageWordLength(filteredWords: List<String>): Double {
        if (filteredWords.isEmpty()) return 0.0
        return filteredWords.sumOf { it.length }.toDouble() / filteredWords.size
    }

    private fun splitWords(text: String): List<String> {
        return WORD_REGEX_PATTERN.findAll(text).map { it.value }.toList()
    }

    private fun List<String>.filterWithStopWords(): List<String> {
        return takeIf { stopWords.isEmpty() } ?: filterNot { it in stopWords }
    }

    private fun WordCounterResult.Companion.Builder.addIndexedWordsIfNeeded(words: List<String>) = apply {
        if (indexed) indexedWords(words.sortedWith(compareBy<String> { it.lowercase() }.thenBy { it[0].isUpperCase() }))
    }
}

