import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WordCounterTest {

    private lateinit var counter: WordCounter

    @BeforeEach
    fun setUp() {
        counter = WordCounter()
    }

    @Test
    fun `word counter simple example`() {
        val input = "Mary had a little lamb"

        val actual = counter.countWords(input)

        assertEquals(5, actual)
    }

    @Test
    fun `illegal chars in words`() {
        val input = "Hell0, my n4me is Markus"

        val actual = counter.countWords(input)

        assertEquals(3, actual)
    }

    @Test
    fun `with commas`() {
        val input = "Hello, my name is Markus."

        val actual = counter.countWords(input)

        assertEquals(5, actual)
    }


}
