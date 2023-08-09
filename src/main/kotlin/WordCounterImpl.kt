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
        )
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
