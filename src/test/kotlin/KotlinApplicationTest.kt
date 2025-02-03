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
    fun testWordCounterStopWordsPositive() {
        val counter = WordCounter()
        val words = testingValueStopWordsPositive.splitToWords()
        val stopWords = getWordsListFromFile("stopwords.txt")
        val count = counter.countWords(words, stopWords)
        Assertions.assertEquals(expectedValuePositive, count)
    }

    @Test
    fun testWordCounterStopWordsNegative() {
        val counter = WordCounter()
        val words = testingValueStopWordsNegative.splitToWords()
        val stopWords = getWordsListFromFile("stopwords.txt")
        val count = counter.countWords(words, stopWords)
        Assertions.assertEquals(expectedValueNegative, count)
    }


    @Test
    fun testWordCounterWordsFromFileStopWordsPositive() {
        val counter = WordCounter()
        val words = getWordsListFromFile("mytexttestpositive.txt")
        val stopWords = getWordsListFromFile("stopwords.txt")
        val count = counter.countWords(words, stopWords)
        Assertions.assertEquals(expectedValuePositive, count)
    }

    @Test
    fun testWordCounterWordsFromFileStopWordsNegative() {
        val counter = WordCounter()
        val words = getWordsListFromFile("mytexttestnegative.txt")
        val stopWords = getWordsListFromFile("stopwords.txt")
        val count = counter.countWords(words, stopWords)
        Assertions.assertEquals(expectedValueNegative, count)
    }
}