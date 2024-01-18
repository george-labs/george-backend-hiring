class WordCounter(
    private val stopWords: Set<String> = emptySet()
) {

    private val whitespaceRegex = "\\s".toRegex()

    fun countWordsInText(text: String): Result {
        // As a future improvement, this reading could be done in a streaming manner, so that
        // we don't have to fit the whole file in memory.
        val words = text
            .split(whitespaceRegex)
            .filter { word ->
                // Stop words should be excluded from the result
                !stopWords.contains(word) &&
                        // On empty input, we could get whitespace as a result of splitting
                        word.isNotEmpty() &&
                        // Words containing digits and special characters should not count as words
                        word.all { it.isLetter() }
            }

        return Result(
            wordCount = words.size,
            uniqueWords = words.distinct().size
        )
    }

    data class Result(
        val wordCount: Int,
        val uniqueWords: Int,
    )
}