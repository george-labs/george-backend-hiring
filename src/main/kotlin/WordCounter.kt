class WordCounter(
    private val stopWords: Set<String> = emptySet()
) {

    private val whitespaceRegex = "\\s".toRegex()

    fun countWordsInInput(text: String): Int {
        return text
            .split(whitespaceRegex)
            .count { word ->
                // Stop words should be excluded from the result
                !stopWords.contains(word) &&
                        // On empty input, we could get whitespace as a result of splitting
                        word.isNotEmpty() &&
                        // Words containing digits and special characters should not count as words
                        word.all { it.isLetter() }
            }
    }

}