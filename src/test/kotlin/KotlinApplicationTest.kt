import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WordCounterTest {

    @Test
    fun `test countWords with 'Mary had a little lamb'`() {
        val wordCounter = WordCounter()
        val testString = "Mary had a little lamb"
        val expectedWordCount = 5

        val actualWordCount = wordCounter.countWords(testString)

        assertEquals(expectedWordCount, actualWordCount, "The word count should be $expectedWordCount")
    }

    @Test
    fun `test countWords with ''`() {
        val wordCounter = WordCounter()
        val testString = ""
        val expectedWordCount = 0

        val actualWordCount = wordCounter.countWords(testString)

        assertEquals(expectedWordCount, actualWordCount, "The word count should be $expectedWordCount")
    }

    @Test
    fun `test countWords with 'WhatIsThis'`() {
        val wordCounter = WordCounter()
        val testString = "WhatIsThis"
        val expectedWordCount = 1

        val actualWordCount = wordCounter.countWords(testString)

        assertEquals(expectedWordCount, actualWordCount, "The word count should be $expectedWordCount")
    }

    @Test
    fun `test countWords with '12316'`() {
        val wordCounter = WordCounter()
        val testString = "12316"
        val expectedWordCount = 0

        val actualWordCount = wordCounter.countWords(testString)

        assertEquals(expectedWordCount, actualWordCount, "The word count should be $expectedWordCount")
    }

    @Test
    fun `test countWords with '123456lamb'`() {
        val wordCounter = WordCounter()
        val testString = "123456lamb"
        val expectedWordCount = 0

        val actualWordCount = wordCounter.countWords(testString)

        assertEquals(expectedWordCount, actualWordCount, "The word count should be $expectedWordCount")
    }
}
