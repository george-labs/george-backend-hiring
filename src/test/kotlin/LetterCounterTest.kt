import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.BigDecimal

class LetterCounterTest {
    @ParameterizedTest
    @CsvSource(
        "'Mary,had,aa,little,lamb', 3.80",
        "'Humpty-Dumpty', 13.00"
    )
    fun averageLettersCount(wordsConcat: String, expectedAverage: BigDecimal) {
        val words = sequenceOf(*wordsConcat.split(",").toTypedArray())

        val result = LetterCounter.averageLettersCount(words)

        assertEquals(expectedAverage, result)
    }

    @Test
    fun averageLettersCountEmpty() {
        val words = sequenceOf<String>()

        val result = LetterCounter.averageLettersCount(words)

        assertEquals(BigDecimal.ZERO, result)
    }

}