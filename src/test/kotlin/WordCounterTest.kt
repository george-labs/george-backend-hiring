import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WordCounterTest {

    private lateinit var counter: WordCounter

    @BeforeEach
    fun setUp() {
        counter = WordCounter(setOf())
    }

    @Test
    fun `should count words`() {
        val (count, unique) = counter.countWords("Hello world TEST")
        assertEquals(3, count)
    }

    @Test
    fun `should not count empty token as word`() {
        val (count, unique) = counter.countWords("  test")
        assertEquals(1, count)
    }

    @Test
    fun `should count zero for empty strings`() {
        val (count, unique) = counter.countWords("       ")
        assertEquals(0, count)
    }


    @Test
    fun `should not count words with characters other than small or capital letters`() {
        val (count, unique) = counter.countWords("one1 two+ three four!")
        assertEquals(1, count)
    }

    @Test
    fun `should not count words multiline`() {
        val (count, unique) = counter.countWords(
            """
            hello world
            on new line
        """.trimIndent()
        )
        assertEquals(5, count)
    }

    @Test
    fun `should not count stop words`() {
        val counterWithStopWords = WordCounter(setOf("forbidden", "tomorrow"))
        val (count, unique) = counterWithStopWords.countWords("one1 Forbidden forbidden tomorrow two+ three four!")
        assertEquals(2, count)
    }

    @Test
    fun `should not count dots`() {
        val (count, unique) = counter.countWords("Hello world. David.")
        assertEquals(3, count)
    }

    @Test
    fun `should count total and unique world`() {
        val counterWithStopWords = WordCounter(
            setOf(
                "the", "a", "on", "off"
            )
        )
        val (count, unique) = counterWithStopWords.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.")
        assertEquals(7, count)
        assertEquals(6, unique)
    }


    @Test
    fun `should not count hyphen only`() {
        val counterWithStopWords = WordCounter(
            setOf(
                "the", "a", "on", "off"
            )
        )
        val (count, unique) = counterWithStopWords.countWords("------- ---------------")
        assertEquals(0, count)
        assertEquals(0, unique)
    }


    @Test
    fun `should not count dots only`() {
        val counterWithStopWords = WordCounter(
            setOf(
                "the", "a", "on", "off"
            )
        )
        val (count, unique) = counterWithStopWords.countWords(".... .... ....")
        assertEquals(0, count)
        assertEquals(0, unique)
    }
}

