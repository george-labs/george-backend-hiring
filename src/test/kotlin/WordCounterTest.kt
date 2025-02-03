import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WordCounterTest {

    private val testingValuePositive = "test testig testo"
    private val testingValueNegative = "t35t 987456 i-o8 i/p"
    private val expectedValuePositive = 3
    private val expectedValueAveragePositive = 5.0f
    private val expectedValueNegative = 0

    @Test
    fun testWordCounterPositive() {
        val counter = WordCounter()
        val words = testingValuePositive.splitToWords()
        val count = counter.countWords(words)
        Assertions.assertEquals(expectedValuePositive, count)
    }

    @Test
    fun testWordCounterNegative() {
        val counter = WordCounter()
        val words = testingValueNegative.splitToWords()
        val count = counter.countWords(words)
        Assertions.assertEquals(expectedValueNegative, count)
    }

    @Test
    fun testWordCounterAveragePositive() {
        val counter = WordCounter()
        val words = testingValuePositive.splitToWords()
        val count = counter.averageWordLength(words)
        Assertions.assertEquals(expectedValueAveragePositive, count)
    }
}