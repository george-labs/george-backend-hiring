import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class WordCounterTest {

    private lateinit var counter: WordCounter

    @BeforeEach
    fun setUp() {
        counter = WordCounter(setOf())
    }

    @Test
    fun `should count words`() {
        val result = counter.countWords("Hello world TEST")
        assertEquals(3, result.totalCount)
    }

    @Test
    fun `should not count empty token as word`() {
        val result = counter.countWords("  test")
        assertEquals(1, result.totalCount)
    }

    @Test
    fun `should count zero for empty strings`() {
        val result = counter.countWords("       ")
        assertEquals(0, result.totalCount)
        assertNull(result.averageWordLength)
    }


    @Test
    fun `should not count words with characters other than small or capital letters`() {
        val result = counter.countWords("one1 two+ three four!")
        assertEquals(1, result.totalCount)
    }

    @Test
    fun `should not count words multiline`() {
        val result = counter.countWords(
            """
            hello world
            on new line
        """.trimIndent()
        )
        assertEquals(5, result.totalCount)
    }

    @Test
    fun `should not count stop words`() {
        val counterWithStopWords = WordCounter(setOf("forbidden", "tomorrow"))
        val result = counterWithStopWords.countWords("one1 Forbidden forbidden tomorrow two+ three four!")
        assertEquals(2, result.totalCount)
    }

    @Test
    fun `should not count dots`() {
        val result = counter.countWords("Hello world. David.")
        assertEquals(3, result.totalCount)
    }

    @Test
    fun `should count total and unique world`() {
        val counterWithStopWords = WordCounter(
            setOf(
                "the", "a", "on", "off"
            )
        )
        val result = counterWithStopWords.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.")
        assertEquals(7, result.totalCount)
        assertEquals(6, result.uniqueWords.size)
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

    @Test
    fun `should calculate average length`() {
        val result = counter.countWords("Hello world TEST")
        assertEquals(BigDecimal("4.67"), result.averageWordLength)
    }

    @Test
    fun `should calculate index`() {
        val result = counter.countWords("Hello world TEST")
        assertEquals(listOf("Hello", "TEST", "world"), result.wordIndex())
    }

}

