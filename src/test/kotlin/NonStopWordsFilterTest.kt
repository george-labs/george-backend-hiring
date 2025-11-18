import WordCounter.Companion.splitWords
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class NonStopWordsFilterTest {

    @ParameterizedTest
    @CsvSource(
        "'Mary had aa little lamb', '', 5",
        "'Mary . had ,4 \n a % little lamb', 'a,on,the',  4",
        "'', 'stuff', 0",
        "'the a on off NotATheOnOff', 'a,on,the', 2",
        "'Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall', 'Humpty,dumpty', 10",
        "'Humpty-Dumpty case-test. Humpty-Dumpty case-Test', 'Humpty-Dumpty case', 4"
    )
    fun filter(input: String, stopWords: String, expectedCount: Int) {
        val tested = NonStopWordsFilter(stopWords.split(','))
        val words = splitWords(input)

        val result = tested.filter(words)

        assertEquals(expectedCount, result.count())
    }

}