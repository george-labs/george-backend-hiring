import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WordCounterTest {
    val TEXT = """
        Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.
    """.trimIndent()

    val STOP_WORDS = setOf("a", "on", "off", "the")

    val EXPECTED_COUNT = 9
    val EXPECTED_UNIQUE_COUNT = 7

    @Test
    fun testCountWords() {
        val wordCounter = WordCounter(STOP_WORDS)
        wordCounter.setInputText(TEXT)

        val noOfWords = wordCounter.countAllWords()
        val noOfUniqueWords = wordCounter.countUniqueWords()

        assertEquals(EXPECTED_COUNT, noOfWords,)
        assertEquals(EXPECTED_UNIQUE_COUNT, noOfUniqueWords)
    }

    @Test
    fun testCountWordsEmpty() {
        val wordCounter = WordCounter(STOP_WORDS)

        val noOfWords = wordCounter.countAllWords()
        val noOfUniqueWords = wordCounter.countUniqueWords()

        assert(noOfWords == 0)
        assert(noOfUniqueWords == 0)
    }

    @Test
    fun testCountStopWords() {
        val wordCounter = WordCounter(setOf())
        wordCounter.setInputText(TEXT)

        val noOfWords = wordCounter.countAllWords()
        val noOfUniqueWords = wordCounter.countUniqueWords()

        assert(noOfWords == 12)
        assert(noOfUniqueWords == 9)
    }
}