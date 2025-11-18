import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WordCounterTest {

    val tested = WordCounter()

    @ParameterizedTest
    @CsvSource(
        "'Mary had a little lamb', 5",
        "'Mary . had , a % little lamb', 5",
        "'Mary 3  had 4  a  little lamb', 5",
        "'M4ry 3  had 4  a  little lamb', 6",
        "'', 0",
        "'1 3 . @ ', 0",
    )
    fun countWordsTest(input: String, expectedCount: Int) {

        val result = tested.countWords(input)

        Assertions.assertEquals(expectedCount, result)
    }

}