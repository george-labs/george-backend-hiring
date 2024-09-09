import iteration1.WordCounter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WordCounterTest {

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

    @Test
    fun testStopWordsRead() {
        val wordCounter = WordCounter()
        val expectedCount = 4
        val actualCount = wordCounter.stopWordsCount()
        assertEquals(expectedCount, actualCount)
    }

    @Test
    fun testStopWordsExcludes() {
        val wordCounter = WordCounter()
        val sentence = "Mary had a little lamb"
        val expectedCount = 4
        val actualCount = wordCounter.countWords(sentence)
        assertEquals(expectedCount, actualCount)
    }

    @Test
    fun testloadedFromFileExcludes() {
        val wordCounter = WordCounter()
        val sentence = "Mary had a little lamb"
        val expectedCount = 4
        val actualCount = wordCounter.countWords(sentence)
        assertEquals(expectedCount, actualCount)
    }

    @Test
    fun testUniqueWordsExcludes() {
        val wordCounter = WordCounter()
        val sentence = "Mary had a little lamb a little lamb"
        val expectedCount = 4
        val actualCount = wordCounter.countUniqueWords(sentence)
        assertEquals(expectedCount, actualCount)
    }

    @Test
    fun testKnownVariety() {
        val wordCounter = WordCounter()
        val sentence = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."
        val expectedWordCount = 9
        val expectedUniqueCount = 7
        val wordCount = wordCounter.countWords(sentence)
        val uniqueCount = wordCounter.countUniqueWords(sentence)
        assertEquals(expectedWordCount, wordCount)
        assertEquals(expectedUniqueCount, uniqueCount)
    }
}