import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WordCounterTest {
    @Test
    fun `returns 0, when input list is empty`() {
        assertEquals(0, countWords(emptyList()))
    }

    @Test
    fun `returns the number of words contained in the input list`() {
        assertEquals(3, countWords(listOf("one", "two", "three")))
    }
}