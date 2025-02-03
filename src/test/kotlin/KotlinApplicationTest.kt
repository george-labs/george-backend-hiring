import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinApplicationTest {

    private val testingValuePositive = "test testing testo"
    private val testingValueStopWordsPositive = "test the testing a testo on off"
    private val testingValueStopWordsNegative = "a on off the"
    private val testingValueNegative = "t35t 987456 i-o8 i/p"
    private val expectedValuePositive = 3
    private val expectedValueNegative = 0

    @Test
    fun testDummy() {
        assert(value = true)
    }

    @Test
    fun testWordCounterPositive() {
        val counter = WordCounter(testingValuePositive)
        val count = counter.countWords(counter.splitToWords())
        Assertions.assertEquals(expectedValuePositive, count)
    }

    @Test
    fun testWordCounterNegative() {
        val counter = WordCounter(testingValueNegative)
        val count = counter.countWords(counter.splitToWords())
        Assertions.assertEquals(expectedValueNegative, count)
    }

    @Test
    fun testWordCounterStopWordsPositive() {
        val counter = WordCounter(testingValueStopWordsPositive)
        val stopWords = getStopWordsListFromFile("stopwords.txt")
        val count = counter.countWords(counter.splitToWords(), stopWords)
        Assertions.assertEquals(expectedValuePositive, count)
    }

    @Test
    fun testWordCounterStopWordsNegative() {
        val counter = WordCounter(testingValueStopWordsNegative)
        val stopWords = getStopWordsListFromFile("stopwords.txt")
        val count = counter.countWords(counter.splitToWords(), stopWords)
        Assertions.assertEquals(expectedValueNegative, count)
    }
}