import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import util.WordCounter
import util.WordFileReader
import util.splitToWords

private const val myTextTestPositiveFilename = "mytexttestpositive.txt"
private const val stopWordsFilename = "stopwords.txt"
private const val myTextTestNegativeFilename = "mytexttestnegative.txt"

private const val myTextTestUniquePositiveFilename = "mytexttestuniquepositive.txt"

class KotlinApplicationTest {

    private val testingValueStopWordsPositive = "test the testing a testo on off"
    private val testingValueStopWordsNegative = "a on off the"
    private val expectedValuePositive = 3
    private val expectedValueAveragePositive = 4.6666665f
    private val expectedValueNegative = 0

    @Test
    fun testDummy() {
        assert(value = true)
    }

    @Test
    fun testWordCounterStopWordsPositive() {
        val counter = WordCounter()
        val words = testingValueStopWordsPositive.splitToWords()
        val stopWords = WordFileReader().getWordsListFromFile(stopWordsFilename, true)
        val count = counter.countWords(words, stopWords)
        Assertions.assertEquals(expectedValuePositive, count)
    }

    @Test
    fun testWordCounterStopWordsNegative() {
        val counter = WordCounter()
        val words = testingValueStopWordsNegative.splitToWords()
        val stopWords = WordFileReader().getWordsListFromFile(stopWordsFilename, true)
        val count = counter.countWords(words, stopWords)
        Assertions.assertEquals(expectedValueNegative, count)
    }


    @Test
    fun testWordCounterWordsFromFileStopWordsPositive() {
        val counter = WordCounter()
        val words = WordFileReader().getWordsListFromFile(myTextTestPositiveFilename, true)
        val stopWords = WordFileReader().getWordsListFromFile(stopWordsFilename)
        val count = counter.countWords(words, stopWords)
        Assertions.assertEquals(expectedValuePositive, count)
    }

    @Test
    fun testWordCounterWordsFromFileStopWordsNegative() {
        val counter = WordCounter()
        val words = WordFileReader().getWordsListFromFile(myTextTestNegativeFilename, true)
        val stopWords = WordFileReader().getWordsListFromFile(stopWordsFilename)
        val count = counter.countWords(words, stopWords)
        Assertions.assertEquals(expectedValueNegative, count)
    }


    @Test
    fun testWordCounterUniqueWordsFromFileStopWordsPositive() {
        val counter = WordCounter()
        val words = WordFileReader().getWordsListFromFile(myTextTestUniquePositiveFilename, true)
        val stopWords = WordFileReader().getWordsListFromFile(stopWordsFilename)
        val count = counter.countWords(words, stopWords)
        Assertions.assertEquals(11, count)
        val countUnique = counter.countUniqueWords(words, stopWords)
        Assertions.assertEquals(4, countUnique)
    }

    @Test
    fun testWordCounterWordsUniqueFromFileStopWordsNegative() {
        val counter = WordCounter()
        val words = WordFileReader().getWordsListFromFile("mytexttestuniquenegative.txt", true)
        val stopWords = WordFileReader().getWordsListFromFile(stopWordsFilename)
        val count = counter.countWords(words, stopWords)
        Assertions.assertEquals(expectedValueNegative, count)
        val countUnique = counter.countUniqueWords(words, stopWords)
        Assertions.assertEquals(expectedValueNegative, countUnique)
    }

    @Test
    fun testWordCounterWordsAverageFromFileStopWordsPositive() {
        val counter = WordCounter()
        val words = WordFileReader().getWordsListFromFile(myTextTestPositiveFilename, true)
        val stopWords = WordFileReader().getWordsListFromFile(stopWordsFilename)
        val count = counter.averageWordLength(words, stopWords)
        Assertions.assertEquals(expectedValueAveragePositive, count)
    }
}