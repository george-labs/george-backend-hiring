import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WordCounterTest {

    private lateinit var counter: WordCounterImpl

    @BeforeEach
    fun setUp() {
        counter = WordCounterImpl()
    }

    private val pairs = listOf(
        "Mary had a little lamb" to WordCounterResult(5, 5),
        "Hell0, my n4me is Markus" to WordCounterResult(3, 3),
        "Hello, my name is Markus." to WordCounterResult(5, 5),
        "" to WordCounterResult.ZERO,
        "   " to WordCounterResult.ZERO,
        "Mary   had a  little       lamb  " to WordCounterResult(5, 5),
        "Hell0, my n4me: is Markus." to WordCounterResult(3, 3),
        "Humpty-Dumpty -Test sat on a wall. Humpty-Dumpty had a great fall." to WordCounterResult(10, 8)
    )

    @Test
    fun `words counter params test`() {
        for (item in pairs) {
            val actual = counter.countWords(item.first)
            assertEquals(item.second, actual, "For input: ${item.first}")
        }
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
}
