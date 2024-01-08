import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class WordCounterTest {

    private lateinit var wordCounter: WordCounter

    @BeforeEach
    fun setUp() {
        wordCounter = WordCounter()
    }

    @Test
    fun testWordsWithAlphaCharactersOnly() {
        assertEquals(3, wordCounter.count("word word word"))
    }

    @Test
    fun testWordsWithAlphaCharactersAndSpacesBeforeAndAfter() {
        assertEquals(3, wordCounter.count("     word word word     "))
    }

    @Test
    fun testWordsWithNonAlphaCharacters() {
        assertEquals(2, wordCounter.count("word w1o2r3d word word,"))
    }

    @Test
    fun testWordsContainingOnlyNonAlphaCharacters() {
        assertEquals(0, wordCounter.count("word1, word. *&!"))
    }

    @Test
    fun testEmptyWords() {
        assertEquals(0, wordCounter.count(""))
    }

    @Test
    fun testWordsFromGivenFileAreSuccessfullyIgnored() {
        val wordsToIgnore = listOf("the", "abc")
        assertEquals(2, wordCounter.count("word the word abc", wordsToIgnore = wordsToIgnore))
    }
}
