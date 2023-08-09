import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class WordCounterTest {

    companion object {

        @JvmStatic
        fun getCounterTestValues(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("Mary had a little lamb", WordCounterResult(5, 5, 3.6)),
                Arguments.of("Hell0, my n4me is Markus", WordCounterResult(3, 3, 3.3333333333333335)),
                Arguments.of("Hello, my name is Markus.", WordCounterResult(5, 5, 3.8)),
                Arguments.of("", WordCounterResult.ZERO),
                Arguments.of(" ", WordCounterResult.ZERO),
                Arguments.of("Mary   had a  little       lamb  ", WordCounterResult(5, 5, 3.6)),
                Arguments.of(
                    "Humpty-Dumpty -Test sat on a wall. Humpty-Dumpty had a great fall.",
                    WordCounterResult(10, 8, 4.9)
                ),
            )
        }
    }

    private lateinit var counter: WordCounterImpl

    @BeforeEach
    fun setUp() {
        counter = WordCounterImpl()
    }

    @ParameterizedTest
    @MethodSource("getCounterTestValues")
    fun `words counter params test`(input: String, expected: WordCounterResult) {
        val actual = counter.countWords(input)
        assertEquals(expected, actual)
    }

    @Test
    fun `match word`() {
        assertEquals(true, counter.alphabetCheck("Humpty-Dumpty"))
        assertEquals(true, counter.alphabetCheck("abc"))
        assertEquals(false, counter.alphabetCheck(""))
        assertEquals(false, counter.alphabetCheck("Hell0"))
        assertEquals(false, counter.alphabetCheck("He\$l0"))
        assertEquals(false, counter.alphabetCheck("-Test"))
    }

    @Test
    fun `calculate average words`() {
        assertEquals(3.0, counter.getAverageWords(listOf("abc")))
        assertEquals(1.5, counter.getAverageWords(listOf("a", "bc")))
        assertEquals(0.0, counter.getAverageWords(listOf()))
    }
}
