import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.sequences.distinct

class WordCounterTest {
    val stopWords: List<String> = listOf(
        "the",
        "a",
        "on",
        "off",
    )
    val tested = WordCounter(listOf(NonStopWordsFilter(stopWords), DistinctFilter()))

    @ParameterizedTest
    @CsvSource(
        "'Mary had aa little lamb', 5, 5",
        "'Mary . had , \n a % little lamb', 4, 4",
        "'Mary 3  had 4  a  little lamb', 4, 4",
        "'M4ry 3  had 4  a  little lamb', 5, 5",
        "'', 0, 0",
        "'the a on off NotATheOnOff', 1, 1",
        "'1 3 . @ ', 0, 0",
        "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall, 9, 7"
    )
    fun countWordsTest(input: String, expectedTotalCount: Int, expectedDistinctCount: Int) {

        val (foundTotalCount, foundDistinctCount) = tested.countWords(input)

        assertEquals(expectedTotalCount, foundTotalCount)
        assertEquals(expectedDistinctCount, foundDistinctCount)
    }

}