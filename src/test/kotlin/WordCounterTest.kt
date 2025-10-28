import org.junit.jupiter.api.Test

class WordCounterTest {
    val TEXT = """
        Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.
    """.trimIndent()

    val EXPECTED_COUNT = 9
    val EXPECTED_UNIQUE_COUNT = 7

    private val wordCounter = WordCounter(FileReaderImpl())

    @Test
    fun testCountWords() {
        val words = wordCounter.getWords(TEXT)

        val noOfWords = wordCounter.countAllWords(words)
        val noOfUniqueWords = wordCounter.countUniqueWords(words)

        assert(noOfWords == EXPECTED_COUNT)
        assert(noOfUniqueWords == EXPECTED_UNIQUE_COUNT)
    }

    @Test
    fun testCountWordsEmpty() {
        val words = wordCounter.getWords("")

        val noOfWords = wordCounter.countAllWords(words)
        val noOfUniqueWords = wordCounter.countUniqueWords(words)

        assert(noOfWords == 0)
        assert(noOfUniqueWords == 0)
    }

    @Test
    fun testCountStopWords() {
        val stopWordsText = wordCounter.getStopWords().joinToString(" ")
        val words = wordCounter.getWords(stopWordsText)

        val noOfWords = wordCounter.countAllWords(words)
        val noOfUniqueWords = wordCounter.countUniqueWords(words)

        assert(noOfWords == 0)
        assert(noOfUniqueWords == 0)
        assert(noOfWords == noOfUniqueWords)
    }

    @Test
    fun testCountAllWords() {
        val wordsList = listOf("apple", "banana", "apple", "orange", "banana", "kiwi")
        val expectedCount = 6

        val actualCount = wordCounter.countAllWords(wordsList)

        assert(actualCount == expectedCount)
    }

    @Test
    fun testCountUniqueWords() {
        val wordsList = listOf("apple", "banana", "apple", "orange", "banana", "kiwi")
        val expectedUniqueCount = 4

        val actualUniqueCount = wordCounter.countUniqueWords(wordsList)

        assert(actualUniqueCount == expectedUniqueCount)
    }

    @Test
    fun testCountAllWordsIfEmpty() {
        val wordsList = listOf<String>()
        val expectedCount = 0

        val actualCount = wordCounter.countAllWords(wordsList)

        assert(actualCount == expectedCount)
    }

    @Test
    fun testCountUniqueWordsIfEmpty() {
        val wordsList = listOf<String>()
        val expectedUniqueCount = 0

        val actualUniqueCount = wordCounter.countUniqueWords(wordsList)

        assert(actualUniqueCount == expectedUniqueCount)
    }
}