class WordCounter(val stopWords: List<String>) {

    internal var regex: Regex = Regex("([a-zA-Z]+)")

    fun countWords(input: String) = regex.findAll(input).map { it.value }
        .count {
            !stopWords.contains(it)
        }

}