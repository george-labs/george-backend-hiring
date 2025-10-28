import org.junit.jupiter.api.Test

class WordCounterTest {

    private val wordCounter = WordCounter(FileReader())

    @Test
    fun testCountWords() {
        val noOfWords = wordCounter.countWords("Mary had a little lamb")
        assert(noOfWords == 4)
    }

    @Test
    fun testCountWordsEmpty() {
        val noOfWords = wordCounter.countWords("")
        assert(noOfWords == 0)
    }

    @Test
    fun testCountStopWords() {
        val stopWordsText = wordCounter.getStopWords().joinToString(" ")
        val noOfWords = wordCounter.countWords(stopWordsText)
        assert(noOfWords == 0)
    }
}