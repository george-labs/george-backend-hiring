package model

class WordCounterResult private constructor(
    val totalWords: Int,
    val uniqueWords: Int,
    val averageWordsLength: Double,
    val indexedWords: List<String>?,
) {
    companion object {
        class Builder {
            private var totalWords: Int? = null
            private var uniqueWords: Int? = null
            private var averageWordsLength: Double? = null
            private var indexedWords: List<String>? = null

            fun totalWords(totalWords: Int) = apply { this.totalWords = totalWords }
            fun uniqueWords(uniqueWords: Int) = apply { this.uniqueWords = uniqueWords }
            fun averageWordsLength(averageWordsLength: Double) = apply { this.averageWordsLength = averageWordsLength }
            fun indexedWords(indexedWords: List<String>?) = apply { this.indexedWords = indexedWords }

            fun build() = WordCounterResult(
                totalWords = requireNotNull(totalWords),
                uniqueWords = requireNotNull(uniqueWords),
                averageWordsLength = requireNotNull(averageWordsLength),
                indexedWords = indexedWords,
            )
        }
    }
}