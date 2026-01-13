package model

data class WordCounterResult(
    val totalWords: Int,
    val uniqueWords: Int,
    val averageWordsLength: Double,
)