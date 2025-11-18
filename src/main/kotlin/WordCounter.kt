class WordCounter(val filters: List<SequenceFilter>) {

    internal var regex: Regex = Regex("([a-zA-Z]+)")

    fun countWords(input: String ): List<Int> {
        var currentList = regex.findAll(input).map { it.value }
        val result = filters.map {
            currentList = it.filter(currentList)
            currentList.count()
        }
        return result
    }

}