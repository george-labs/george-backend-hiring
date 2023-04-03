import java.math.BigDecimal
import java.math.RoundingMode

class WordCounter(private val stopWords: Set<String>) {

    fun countWords(input: String): CounterResult = input
        .split(" ", "\n", ".")
        .asSequence()
        .filter { it.matches(Regex("[a-zA-Z]+-?[a-zA-Z]*")) }
        .filter { !stopWords.contains(it) }
        .fold(CounterAccumulator(0, 0, setOf())) { acc, word ->
            acc.copy(
                totalWordCount = acc.totalWordCount.inc(),
                totalWordLength = acc.totalWordLength + word.length,
                unique = acc.unique + word
            )
        }
        .let { acc ->
            CounterResult(
                acc.totalWordCount,
                acc.unique.size,
                acc.averageWordLength()
            )
        }

    private data class CounterAccumulator(val totalWordCount: Int, val totalWordLength: Long, val unique: Set<String>) {

        fun averageWordLength(): BigDecimal? = totalWordCount.takeIf { it > 0 }?.let { totalCount ->
            totalWordLength.toBigDecimal().divide(totalCount.toBigDecimal(), 2, RoundingMode.HALF_UP)
        }

    }

    data class CounterResult(val total: Int, val unique: Int, val averageLengthOfTheWord: BigDecimal?)

}
