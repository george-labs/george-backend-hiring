class WordCounterImpl(
    private val stopWordsProvider: StopWordsProvider = EmptyStopWordsProvider(),
) : WordCounter {

    override fun countWords(input: String): WordCounterResult {
        val words = input.split(" ")
            .map { removeSpecialSymbols(it) }
            .filter { alphabetCheck(it) }
            .filter { !stopWordsProvider.isBanned(it) }

        return WordCounterResult(
            numberOfWords = words.size,
            unique = words.toSet().size,
            averageWordLength = getAverageWords(words),
        )
    }

    internal fun getAverageWords(words: List<String>): Double {
        if (words.isEmpty()) {
            return 0.0
        }
        var counter = 0.0
        words.forEach { counter += it.length }
        return counter / words.size.toDouble()
    }

    internal fun alphabetCheck(input: String): Boolean {
        return MAIN_REGEX.matches(input) || HYPHEN_REGEX.matches(input)
    }

    private fun removeSpecialSymbols(input: String): String {
        return input.filterNot { SPECIAL_SYMBOLS.indexOf(it) > -1 }
    }

    companion object {
        const val SPECIAL_SYMBOLS = ".,;:"

        val MAIN_REGEX = Regex("[a-zA-Z]+?")
        val HYPHEN_REGEX = Regex("[a-zA-Z]+-[a-zA-Z]+\\.?")
    }
}
