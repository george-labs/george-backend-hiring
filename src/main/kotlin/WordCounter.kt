class WordCounter(
    private val stopWords: Set<String> = emptySet()
) {

    private val whitespaceRegex = "\\s".toRegex()

    fun countWordsInText(text: String): Result {
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