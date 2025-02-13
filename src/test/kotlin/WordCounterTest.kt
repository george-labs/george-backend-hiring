import impl.StopWordContext
import mock.MockedStopWordContext
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WordCounterTest {

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
    )
    fun `Word counter test`(input: String, expected: Int) {
        val stopWordContext = StopWordContext()
        val actual = WordCounter(stopWordContext).countWords(input)

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
    )
    fun `IsWord test`(input: String, expected: Boolean) {
        val mockedFileLoader = MockedStopWordContext()
        val actual = WordCounter(mockedFileLoader).isWord(input)

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
        val stopWordContext = StopWordContext()
        val actual = WordCounter(stopWordContext).isStopword(input)

        assertEquals(expected, actual);
    }
}