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

    private fun alphabetCheck(input: String): Boolean {
        val regex = Regex("[a-zA-Z]+?")
        return regex.matches(input)
    }

    private fun removeSpecialSymbols(input: String): String {
        return input.filterNot { SPECIAL_SYMBOLS.indexOf(it) > -1 }
    }

    companion object {
        const val SPECIAL_SYMBOLS = ".,;:"
    }
}
