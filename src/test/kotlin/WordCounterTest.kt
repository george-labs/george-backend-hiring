import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WordCounterTest {
    private val counter = WordCounter(listOf("the", "a", "on", "off"))

    @Test
    fun `returns 0, when input list is empty`() {
        assertEquals(0, counter.countWords(emptyList()))
    }

    @Test
    fun `returns the number of words contained in the input list`() {
        assertEquals(3, counter.countWords(listOf("one", "two", "three")))
    }

    @Test
    fun `returns the number of valid words contained in the input list`() {
        assertEquals(3, counter.countWords(listOf("one", "two", "three", "a", "the")))
    }

    @Test
    fun `returns 0, when input only contains stop words`() {
        assertEquals(0, counter.countWords(listOf("a", "the", "on", "off")))
    }

    @Test
    fun `mixed case stop words are also filtered out`() {
        assertEquals(0, counter.countWords(listOf("a", "The", "oN", "oFf")))
    }

    @Test
    fun `uppercase stop words are also filtered out`() {
        assertEquals(0, counter.countWords(listOf("A", "THE", "ON", "OFF")))
    }
}