import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WordCounterTest {

    private lateinit var counter: WordCounter

    @BeforeEach
    fun setUp() {
        counter = WordCounter()
    }

    private val pairs = listOf(
        "Mary had a little lamb" to 5,
        "Hell0, my n4me is Markus" to 3,
        "Hello, my name is Markus." to 5,
        "" to 0,
        "   " to 0,
        "Mary   had a  little       lamb  " to 5,
        "Hell0, my n4me: is Markus." to 3,
    )

    @Test
    fun `words counter params test`() {
        for (item in pairs) {
            val actual = counter.countWords(item.first)
            assertEquals(item.second, actual, "For input: ${item.first}")
        }
    }
}
