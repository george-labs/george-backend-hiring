class WordCounter(val stopWords: List<String>) {

    internal var regex: Regex = Regex("([a-zA-Z]+)")

    fun countWords(input: String, counter1: (Sequence<String>) -> Int, counter2 : (Sequence<String>) -> Int ): Pair<Int, Int> {
        val allWords = regex.findAll(input).map { it.value }
        val nonStopWords = allWords.filter { !stopWords.contains(it) }

        return counter1(nonStopWords) to counter2(nonStopWords)
    }

}