import impl.StopWordContext
import mock.MockedStopWordContext
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WordCounterTest {

    private val stopWordContext = StopWordContext()

    // Note: I would also refactor this as it is overly complicated now and it is hard to spot mistakes in the string (for all test cases)
    @ParameterizedTest
    @CsvSource(
        "'Hello World', 2",
        "'Hello World!', 1",
        "'Hello World something else', 4",
        "'Hello', 1",
        "'', 0",
        "'Looooooooooooooooooooooooooooooooong dsadas', 2",
        "'Many space             something   \n   test   ', 4",
        "'the a on off', 0",
        "'the a on hello world', 2",
        "'theaon hello world', 3",
        "'Humpty-Dumpty', 1",
        "'Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.', 7",
        "'Humpty-Dum.pty sat on a wall', 2",
        "'Hum-pty-Dumpty sat on a wall.', 2",
        "'Stopword test on.', 2",
        "'Stopword with comma, test on, test on.', 5",

        )
    fun `Word counter test`(input: String, expected: Int) {
        val actual = WordCounter(stopWordContext).getWordsWithoutStopwords(input).count()

        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @CsvSource(
        "'Hello Hello World', 2",
        "'Hello World!', 1",
        "'Hello World something else else else else', 4",

        )
    fun `Unique Word counter test`(input: String, expected: Int) {
        val wordCounter = WordCounter(stopWordContext)
        val actual = wordCounter.countUniqueWords(wordCounter.getWordsWithoutStopwords(input))

        assertEquals(expected, actual)
    }


    @ParameterizedTest
    @CsvSource(
        "'Hello', true",
        "'World!', false",
        "'Hello World something else', false",
        "'', false",
        "' ', false",
        "'!!!', false",
        "'Word', true",
        "'Word ', false",
        "'\n ', false",
        "'test-test', true",
        "test--test', false",
        "test-', false",
        "-test-', false",
    )
    fun `IsWord test`(input: String, expected: Boolean) {
        val actual = WordCounter(MockedStopWordContext()).isWord(input)

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
        "'Hello.', Hello",
        "'World.,', World.",
        "'Hello', Hello",
    )
    fun `RemoveLastDotOrComma test`(input: String, expected: String) {
        val actual = WordCounter(MockedStopWordContext()).removeTrailingDotOrComma(input)

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
        "'Hello', false",
        "'World!', false",
        "'the', true",
        "'a', true",
        "'on', true",
        "'off', true",
        "'\n ', false",
        "'Word ', false",
    )
    fun `IsStopword test`(input: String, expected: Boolean) {
        val actual = WordCounter(stopWordContext).isStopword(input)

        assertEquals(expected, actual);
    }
}