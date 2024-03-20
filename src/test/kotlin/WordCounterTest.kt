import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WordCounterTest {

    private val noStopWordsReaderGlobal = TestFileReader(emptyList())

    @Test
    fun `test countWords with 'Mary had a little lamb'`() {
        val noStopWordsReader = TestFileReader(emptyList())
        val wordCounter = WordCounter(noStopWordsReader)
        val testString = "Mary had a little lamb"
        val expectedWordCount = 5

        val actualWordCount = wordCounter.countWords(testString)

        assertEquals(expectedWordCount, actualWordCount, "The word count should be $expectedWordCount")
    }
    @Test
    fun `test countWords with comma and point 'Mary had a little lamb' and stopwords`() {
        val stopWordsReader = TestFileReader(listOf("the", "a", "on", "off"))
        val wordCounter = WordCounter(stopWordsReader)
        val testString = "Mary, you had a little the lamb on."
        val expectedWordCount = 5

        val actualWordCount = wordCounter.countWords(testString)

        assertEquals(expectedWordCount, actualWordCount, "The word count should be $expectedWordCount")
    }

    @Test
    fun `test countWords with only stopwords`() {
        val stopWordsReader = TestFileReader(listOf("the", "a", "on", "off"))
        val wordCounter = WordCounter(stopWordsReader)
        val testString = "the a on off"
        val expectedWordCount = 0

        val actualWordCount = wordCounter.countWords(testString)

        assertEquals(expectedWordCount, actualWordCount, "The word count should be $expectedWordCount")
    }

    @Test
    fun `test countWords with 'Mary had a little lamb' with stopwords`() {
        val stopWordsReader = TestFileReader(listOf("the", "a", "on", "off"))
        val wordCounter = WordCounter(stopWordsReader)
        val testString = "Mary had a little lamb"
        val expectedWordCount = 4

        val actualWordCount = wordCounter.countWords(testString)

        assertEquals(expectedWordCount, actualWordCount, "The word count should be $expectedWordCount")
    }

    @Test
    fun `test countWords with ''`() {
        val wordCounter = WordCounter(noStopWordsReaderGlobal)
        val testString = ""
        val expectedWordCount = 0

        val actualWordCount = wordCounter.countWords(testString)

        assertEquals(expectedWordCount, actualWordCount, "The word count should be $expectedWordCount")
    }

    @Test
    fun `test countWords with 'WhatIsThis'`() {
        val wordCounter = WordCounter(noStopWordsReaderGlobal)
        val testString = "WhatIsThis"
        val expectedWordCount = 1

        val actualWordCount = wordCounter.countWords(testString)

        assertEquals(expectedWordCount, actualWordCount, "The word count should be $expectedWordCount")
    }

    @Test
    fun `test countWords with '12316'`() {
        val wordCounter = WordCounter(noStopWordsReaderGlobal)
        val testString = "12316"
        val expectedWordCount = 0

        val actualWordCount = wordCounter.countWords(testString)

        assertEquals(expectedWordCount, actualWordCount, "The word count should be $expectedWordCount")
    }

    @Test
    fun `test countWords with '123456lamb'`() {
        val wordCounter = WordCounter(noStopWordsReaderGlobal)
        val testString = "123456lamb"
        val expectedWordCount = 0

        val actualWordCount = wordCounter.countWords(testString)

        assertEquals(expectedWordCount, actualWordCount, "The word count should be $expectedWordCount")
    }



    @Test
    fun `test countWords with 'Ma$y'`() {
        val wordCounter = WordCounter(noStopWordsReaderGlobal)
        val testString = "Ma\$y"
        val expectedWordCount = 0

        val actualWordCount = wordCounter.countWords(testString)

        assertEquals(expectedWordCount, actualWordCount, "The word count should be $expectedWordCount")
    }

    @Test
    fun `test countWords with 'Mary had 1 little lamb'`() {
        val wordCounter = WordCounter(noStopWordsReaderGlobal)
        val testString = "Mary had 1 little lamb"
        val expectedWordCount = 4

        val actualWordCount = wordCounter.countWords(testString)

        assertEquals(expectedWordCount, actualWordCount, "The word count should be $expectedWordCount")
    }
}
