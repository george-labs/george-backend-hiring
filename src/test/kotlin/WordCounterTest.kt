import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class WordCounterTest {

    @Test
    fun testWordsWithAlphaCharactersOnly() {
        val wordCounter = WordCounter()

        assertEquals(3, wordCounter.count("word word word"))
    }

    @Test
    fun testWordsWithAlphaCharactersAndSpacesBeforeAndAfter() {
        val wordCounter = WordCounter()

        assertEquals(3, wordCounter.count("     word word word     "))
    }

    @Test
    fun testWordsWithNonAlphaCharacters() {
        val wordCounter = WordCounter()

        assertEquals(2, wordCounter.count("word w1o2r3d word word,"))
    }

    @Test
    fun testWordsContainingOnlyNonAlphaCharacters() {
        val wordCounter = WordCounter()

        assertEquals(0, wordCounter.count("word1, word. *&!"))
    }

    @Test
    fun testEmptyWords() {
        val wordCounter = WordCounter()

        assertEquals(0, wordCounter.count(""))
    }
}
