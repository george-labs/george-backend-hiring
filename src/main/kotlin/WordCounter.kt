class WordCounter(
    private val stopWords: Set<String> = emptySet()
) {

    private val whitespaceRegex = "\\s".toRegex()

    fun countWordsInText(text: String): Result {
        // As a future improvement, this reading could be done in a streaming manner, so that
        // we don't have to fit the whole file in memory.
        val words = text
            .split(whitespaceRegex)
            .filter { isWord(it) }

        return Result(
            wordCount = words.size,
            uniqueWords = words.distinct().size
        )
    }

    private fun isWord(word: String): Boolean {
        if (stopWords.contains(word)) {
            // Stop words should be excluded from the result
            return false
        }

        if (word.isEmpty()) {
            // On empty input, we could get whitespace as a result of splitting
            return false
        }

        word.forEachIndexed { index, c ->
            when {
                // Hyphen is a special character that is valid, when it is in the middle of a word
                c == '-' -> {
                    // As per our assumptions, hyphen at the start or end is not valid
                    if (index == 0 || index == word.lastIndex) {
                        return false
                    }
                }

                c.isPunctuationMark() -> {
                    // Punctuation marks at the end of the word are fine
                    if (index != word.lastIndex) {
                        return false
                    }
                }

                // Words containing digits and special characters should not count as words
                !c.isLetter() -> return false
            }
        }

        return true
    }

    data class Result(
        val wordCount: Int,
        val uniqueWords: Int,
    )

    private fun Char.isPunctuationMark() = when(this) {
        ',', '.', '?', '!' -> true
        else -> false
    }
}