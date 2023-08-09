class WordCounter {

    //a-z,A-Z
    // Hello, my name is Markus.
    fun countWords(input: String): Int {
        return input.split(" ")
            .map { removeSpecialSymbols(it) }
            .filter { alphabetCheck(it) }
            .size
    }

    private fun alphabetCheck(input: String): Boolean {
        val regex = Regex("[a-zA-Z]+?")
        return regex.matches(input)
    }

    fun removeSpecialSymbols(input: String): String {
        return input.filterNot { SPECIAL_SYMBOLS.indexOf(it) > -1 }
    }

    companion object {
        const val SPECIAL_SYMBOLS = ".,;:"
    }
}
