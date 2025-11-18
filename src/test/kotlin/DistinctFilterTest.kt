import WordCounter.Companion.ACCEPTABLE_LETTERS
import WordCounter.Companion.splitWords
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class DistinctFilterTest {

    @ParameterizedTest
    @CsvSource(
        "'Mary had aa little lamb', 5",
        "'Mary . had ,4 \n a % little lamb',  5",
        "'', 0",
        "Humpty-Dumpty sat on a wall. Humpty-dumpty had a great fall, 10"
    )
    fun filter(input: String,  expectedCount: Int) {
        val tested = DistinctFilter()
        val words = splitWords(input)

        val result = tested.filter(words)

        assertEquals(expectedCount, result.count())
    }


}