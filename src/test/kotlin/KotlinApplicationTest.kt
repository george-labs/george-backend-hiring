import extensions.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinApplicationTest {
    private val testWords = "Mary had a little lamb"
    private val notWords = "123 )(* +| 45 !"

    private val notWordsStop = "123 )(* +| 45 ! the"

    private val wordsFileName = "mytext.txt"
    private val notWordsFileName = "mynottext.txt"

    private val wordsUniqueFileName = "myuniquetext.txt"
    private val testUniqueWords = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."
    private val testUniqueWordsSorted = listOf(
        "fall", "great", "had", "Humpty-Dumpty", "Humpty-Dumpty", "sat", "wall"
    )

    init {

    }

    @Test
    fun dummyTest() {
        assert("dummy".isNotBlank())
    }

    @Test
    fun testWordCount() {
        assertEquals(5, testWords.getDividedWords().countWords())
    }

    @Test
    fun testNotWordCount() {
        assertEquals(0, notWords.getDividedWords().countWords())
    }

    @Test
    fun testWordCountStopWords() {
        assertEquals(4, testWords.getDividedWords().getFilteredWords(FileReader().readStopWords()).countWords())
    }

    @Test
    fun testNotWordCountStopWords() {
        assertEquals(0, notWordsStop.getDividedWords().getFilteredWords(FileReader().readStopWords()).countWords())
    }

    @Test
    fun testWordCountMyTextStopWords() {
        assertEquals(
            4,
            FileReader().readWords(wordsFileName)?.getFilteredWords(FileReader().readStopWords())?.countWords()
        )
    }

    @Test
    fun testNotWordCountMyTextStopWords() {
        assertEquals(
            0,
            FileReader().readWords(notWordsFileName)?.getFilteredWords(FileReader().readStopWords())?.countWords()
        )
    }

    @Test
    fun testWordCountUniqueInputStopWords() {
        assertEquals(7, testUniqueWords.getDividedWords().getFilteredWords(FileReader().readStopWords()).countWords())
    }

    @Test
    fun testUniqueWordCountStopWords() {
        assertEquals(6, testUniqueWords.getDividedWords().getFilteredWords(FileReader().readStopWords()).countUnique())
    }

    @Test
    fun testUniqueWordCountMyTextStopWords() {
        assertEquals(
            6,
            FileReader().readWords(wordsUniqueFileName)?.getFilteredWords(FileReader().readStopWords())?.countUnique()
        )
    }

    @Test
    fun testAverageWordCountStopWords() {
        assertEquals(
            "8,43",
            testUniqueWords.getDividedWords().getFilteredWords(FileReader().readStopWords()).countAverageWordLength()
        )
    }

    @Test
    fun testAverageWordCountMyTextStopWords() {
        assertEquals(
            "8,43",
            FileReader().readWords(wordsUniqueFileName)?.getFilteredWords(FileReader().readStopWords())
                ?.countAverageWordLength()
        )
    }

    @Test
    fun testSortMyTextStopWords() {
        assertEquals(
            testUniqueWordsSorted,
            FileReader().readWords(wordsUniqueFileName)?.getFilteredWords(FileReader().readStopWords())?.sortWords()
        )
    }
}