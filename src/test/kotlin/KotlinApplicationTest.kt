import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class KotlinApplicationTest {

    @ParameterizedTest
    @CsvSource(
        "Hello World, 2",
        "Hello World!, 0",
        "Hello World something else, 4",
        "Hello, 1",
        "'', 0",
        "Looooooooooooooooooooooooooooooooong dsadas, 2",
        "Many space             something \n         "
    )
    fun `Word counter happy path test`(input: String, expected: Int) {
        val actual = WordCounter.countWords(input)
        assertEquals(expected, actual);
    }
}