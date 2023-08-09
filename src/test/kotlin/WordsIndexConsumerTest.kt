import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WordsIndexConsumerTest {

    private lateinit var wordsIndexConsumer: WordsIndexConsumer

    @BeforeEach
    fun setUp() {
        wordsIndexConsumer = WordsIndexConsumer()
    }

    @Test
    fun `check order`() {
        val input = listOf("Mary", "had", "little", "lamb")
        val expected = listOf("had", "lamb", "little", "Mary")

        val actual = wordsIndexConsumer.accept(input)

        assertEquals(expected, actual)
    }
}
