class WordCounter(private val stopWords: Set<String>) {

    fun countWords(input: String): CounterResult = input
        .split(" ", "\n", ".")
        .asSequence()
        .filter { it.matches(Regex("[a-zA-Z]+-?[a-zA-Z]*")) }
        .filter { !stopWords.contains(it) }
        .fold(CounterAccumulator(0, setOf())) { acc, word ->
            acc.copy(totalWordCount = acc.totalWordCount.inc(), unique = acc.unique + word)
        }
        .let { acc -> CounterResult(acc.totalWordCount, acc.unique.size) }

    private data class CounterAccumulator(val totalWordCount: Int, val unique: Set<String>)

    data class CounterResult(val total: Int, val unique: Int)

}
