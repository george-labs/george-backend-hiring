import java.math.BigDecimal
import java.math.RoundingMode

class WordCounter(private val stopWords: Set<String>) {

    fun countWords(input: String): CounterResult = input
        .split(" ", "\n", ".")
        .asSequence()
        .filter { it.matches(Regex("[a-zA-Z]+-?[a-zA-Z]*")) }
        .filter { !stopWords.contains(it) }
        .fold(CounterResult(0, 0, setOf())) { acc, word ->
            acc.copy(
                total = acc.total.inc(),
                totalWordLength = acc.totalWordLength + word.length,
                uniqueWords = acc.uniqueWords + word
            )
        }

    data class CounterResult(val total: Int, val totalWordLength: Long, val uniqueWords: Set<String>) {

        val averageWordLength: BigDecimal?
            get() = total.takeIf { it > 0 }?.let { totalCount ->
                totalWordLength.toBigDecimal().divide(totalCount.toBigDecimal(), 2, RoundingMode.HALF_UP)
            }

        fun wordIndex(): List<String> = uniqueWords.sorted()


    }

}
