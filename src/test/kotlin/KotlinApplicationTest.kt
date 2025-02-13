import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class KotlinApplicationTest {

    @ParameterizedTest
    @CsvSource(
        "'Hello World', 2",
        "'Hello World!', 1",
        "'Hello World something else', 4",
        "'Hello', 1",
        "'', 0",
        "'Looooooooooooooooooooooooooooooooong dsadas', 2",
        "'Many space             something   \n   test   ', 4",
    )
    fun `Word counter test`(input: String, expected: Int) {
        val actual = WordCounter.countWords(input)
        assertEquals(expected, actual);
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
        val actual = WordCounter.isWord(input)
        assertEquals(expected, actual);
    }
}