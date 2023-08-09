class WordCounterImpl(
    private val stopWordsProvider: StopWordsProvider = EmptyStopWordsProvider(),
) : WordCounter {

    override fun countWords(input: String): WordCounterResult {
        val words = input.split(" ")
            .flatMap { splitWords(it) }
            .map { removeSpecialSymbols(it) }
            .filter { alphabetCheck(it) }
            .filter { !stopWordsProvider.isBanned(it) }

        return WordCounterResult(
            numberOfWords = words.size,
            unique = words.toSet().size,
        )
    }

    internal fun splitWords(input: String): List<String> {
        val index = input.indexOf("-")
        return if (index != -1 && index != input.length - 1) {
            listOf(input.substring(0, index), input.substring(index + 1, input.length))
        } else {
            listOf(input)
        }
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
