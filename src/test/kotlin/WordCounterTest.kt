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
        val count = counter.countWords("Hello world TEST")
        assertEquals(3, count)
    }

    @Test
    fun `should not count empty token as word`() {
        val count = counter.countWords("  test")
        assertEquals(1, count)
    }

    @Test
    fun `should count zero for empty strings`() {
        val count = counter.countWords("       ")
        assertEquals(0, count)
    }


    @Test
    fun `should not count words with characters other than small or capital letters`() {
        val count = counter.countWords("one1 two+ three four!")
        assertEquals(1, count)
    }

    @Test
    fun `should not count words multiline`() {
        val count = counter.countWords("""
            hello world
            on new line
        """.trimIndent())
        assertEquals(5, count)
    }

    @Test
    fun `should not count stop words`() {
        val counterWithStopWords = WordCounter(setOf("forbidden", "tomorrow"))
        val count = counterWithStopWords.countWords("one1 Forbidden forbidden tomorrow two+ three four!")
        assertEquals(2, count)
    }


}

