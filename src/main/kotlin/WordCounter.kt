class WordCounter(val filters: List<SequenceFilter>) {

    companion object {
        internal var ACCEPTABLE_LETTERS: Regex = Regex("([a-zA-Z-]+)")
        fun splitWords(input: String) = ACCEPTABLE_LETTERS.findAll(input).map { it.value }
    }

    fun countWords(input: String): List<Sequence<String>> {
        var currentList = splitWords(input)
        val result = filters.map {
            currentList = it.filter(currentList)
            currentList
        }

        return result
    }

}