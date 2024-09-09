import iteration1.WordCounter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WordCounterTest {

    @Test
    fun testSentenceCountWords() {
        val wordCounter = WordCounter()
        val sentence = "Mary had a little lamb"
        val expectedCount = 5
        val actualCount = wordCounter.countWords(sentence)
        assertEquals(expectedCount, actualCount)
    }

    @Test
    fun testEmptyCountWords() {
        val wordCounter = WordCounter()
        val sentence = "Mary had 4 little lamb"
        val expectedCount = 4
        val actualCount = wordCounter.countWords(sentence)
        assertEquals(expectedCount, actualCount)
    }

    @Test
    fun testNull() {
        val wordCounter = WordCounter()
        val sentence = null
        val expectedCount = 0
        val actualCount = wordCounter.countWords(sentence)
        assertEquals(expectedCount, actualCount)
    }
}