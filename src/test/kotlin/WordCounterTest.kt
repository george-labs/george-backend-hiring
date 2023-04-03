import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WordCounterTest {

    @Test
    fun `should count words`() {
        val count = WordCounter.countWords("Hello world TEST")
        assertEquals(3, count)
    }

    @Test
    fun `should not count empty token as word`() {
        val count = WordCounter.countWords("  test")
        assertEquals(1, count)
    }

    @Test
    fun `should count zero for empty strings`() {
        val count = WordCounter.countWords("       ")
        assertEquals(0, count)
    }


    @Test
    fun `should not count words with characters other than small or capital letters`() {
        val count = WordCounter.countWords("one1 two+ three four!")
        assertEquals(1, count)
    }

    @Test
    fun `should not count words multiline`() {
        val count = WordCounter.countWords("""
            hello world
            on new line
        """.trimIndent())
        assertEquals(5, count)
    }


}

