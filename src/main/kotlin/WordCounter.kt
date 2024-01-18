interface WordCounter {
    fun countWordsInText(text: String, indexFlag: Boolean = false): Result

    data class Result(
        val wordCount: Int,
        val uniqueWords: Int,
        val averageWordLength: Double,
    )
}

class WordCounterImpl(
    private val stopWords: Set<String> = emptySet()
) : WordCounter {

    private val whitespaceRegex = "\\s".toRegex()

    override fun countWordsInText(text: String, indexFlag: Boolean): WordCounter.Result {
        // As a future improvement, this reading could be done in a streaming manner, so that
        // we don't have to fit the whole file in memory.
        val words = text
            .split(whitespaceRegex)
            .filter { isWord(it) }

        val averageWordLength = getAverageWordLength(words)

        return WordCounter.Result(
            wordCount = words.size,
            uniqueWords = words.distinct().size,
            averageWordLength = averageWordLength
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

        return word
            .asSequence()
            .mapIndexed { index, c -> isValidWordCharacter(c, index, word) }
            .all { it }
    }

    /**
     * @return Returns if character can be used to form a valid word.
     */
    private fun isValidWordCharacter(c: Char, index: Int, word: String): Boolean {
        return when {
            // Hyphen is a special character that is valid, when it is in the middle of a word
            // As per our assumptions, hyphen at the start or end is not valid
            c == '-' -> index > 0 && index < word.lastIndex

            // Punctuation marks at the end of the word are fine
            c.isPunctuationMark() -> index == word.lastIndex

            // Words containing digits and special characters should not count as words
            !c.isLetter() -> false

            else -> true
        }
    }

    private fun getAverageWordLength(words: List<String>): Double {
        // If there are no words, we would do a division by 0 and therefore get NaN as a result.
        if (words.isEmpty()) {
            return 0.0
        }

        // In case there are many/long words in the input it would be possible for
        // Int to overflow, so we need to convert to Long.
        val totalCharacters = words.sumOf { it.length.toLong() }
        return totalCharacters / words.size.toDouble()
    }

    private fun Char.isPunctuationMark() = when (this) {
        ',', '.', '?', '!' -> true
        else -> false
    }
}