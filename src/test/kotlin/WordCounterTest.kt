import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WordCounterTest {

    val stopWords: List<String> = listOf(
        "the",
        "a",
        "on",
        "off",
    )
    val tested = WordCounter(stopWords)

    @ParameterizedTest
    @CsvSource(
        "'Mary had aa little lamb', 5",
        "'Mary . had , a % little lamb', 4",
        "'Mary 3  had 4  a  little lamb', 4",
        "'M4ry 3  had 4  a  little lamb', 5",
        "'', 0",
        "'the a on off NotATheOnOff', 1",
        "'1 3 . @ ', 0",
    )
    fun countWordsTest(input: String, expectedCount: Int) {
        val result = tested.countWords(input)

        Assertions.assertEquals(expectedCount, result)
    }

}