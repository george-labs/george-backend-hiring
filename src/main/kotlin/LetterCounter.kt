import java.math.BigDecimal
import java.math.RoundingMode

object LetterCounter {
    fun averageLettersCount(words: Sequence<String>): BigDecimal =
        if (words.count() == 0) BigDecimal.ZERO else {
            val lettersTotal = BigDecimal(words.map { it.length }.sum())
            lettersTotal.divide(BigDecimal(words.count()), 2, RoundingMode.HALF_DOWN)
        }

}