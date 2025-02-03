import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinApplicationTest {

    private val testingValueStopWordsPositive = "test the testing a testo on off"
    private val testingValueStopWordsNegative = "a on off the"
    private val expectedValuePositive = 3
    private val expectedValueNegative = 0

    @Test
    fun testDummy() {
        assert(value = true)
    }

    @Test
    fun testWordCounterStopWordsPositive() {
        val counter = WordCounter()
        val words = testingValueStopWordsPositive.splitToWords()
        val stopWords = getWordsListFromFile("stopwords.txt", true)
        val count = counter.countWords(words, stopWords)
        Assertions.assertEquals(expectedValuePositive, count)
    }

    @Test
    fun testWordCounterStopWordsNegative() {
        val counter = WordCounter()
        val words = testingValueStopWordsNegative.splitToWords()
        val stopWords = getWordsListFromFile("stopwords.txt", true)
        val count = counter.countWords(words, stopWords)
        Assertions.assertEquals(expectedValueNegative, count)
    }


    @Test
    fun testWordCounterWordsFromFileStopWordsPositive() {
        val counter = WordCounter()
        val words = getWordsListFromFile("mytexttestpositive.txt", true)
        val stopWords = getWordsListFromFile("stopwords.txt")
        val count = counter.countWords(words, stopWords)
        Assertions.assertEquals(expectedValuePositive, count)
    }

    @Test
    fun testWordCounterWordsFromFileStopWordsNegative() {
        val counter = WordCounter()
        val words = getWordsListFromFile("mytexttestnegative.txt", true)
        val stopWords = getWordsListFromFile("stopwords.txt")
        val count = counter.countWords(words, stopWords)
        Assertions.assertEquals(expectedValueNegative, count)
    }


    @Test
    fun testWordCounterUniqueWordsFromFileStopWordsPositive() {
        val counter = WordCounter()
        val words = getWordsListFromFile("mytexttestuniquepositive.txt", true)
        val stopWords = getWordsListFromFile("stopwords.txt")
        val count = counter.countWords(words, stopWords)
        Assertions.assertEquals(11, count)
        val countUnique = counter.countUniqueWords(words, stopWords)
        Assertions.assertEquals(4, countUnique)
    }

    @Test
    fun testWordCounterWordsUniqueFromFileStopWordsNegative() {
        val counter = WordCounter()
        val words = getWordsListFromFile("mytexttestuniquenegative.txt", true)
        val stopWords = getWordsListFromFile("stopwords.txt")
        val count = counter.countWords(words, stopWords)
        Assertions.assertEquals(expectedValueNegative, count)
        val countUnique = counter.countUniqueWords(words, stopWords)
        Assertions.assertEquals(expectedValueNegative, countUnique)
    }
}