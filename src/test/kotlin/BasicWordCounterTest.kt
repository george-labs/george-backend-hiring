import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BasicWordCounterTest {

    private lateinit var basicWordCounter: BasicWordCounter

    @BeforeEach
    fun setUp() {
        basicWordCounter = BasicWordCounter()
    }

    @Test
    fun testWordsWithAlphaCharactersOnly() {
        assertEquals(3, basicWordCounter.count("word word word"))
    }

    @Test
    fun testWordsWithAlphaCharactersAndSpacesBeforeAndAfter() {
        assertEquals(3, basicWordCounter.count("     word word word     "))
    }

    @Test
    fun testWordsWithNonAlphaCharacters() {
        assertEquals(2, basicWordCounter.count("word w1o2r3d word word,"))
    }

    @Test
    fun testWordsContainingOnlyNonAlphaCharacters() {
        assertEquals(0, basicWordCounter.count("word1, word. *&!"))
    }

    @Test
    fun testEmptyWords() {
        assertEquals(0, basicWordCounter.count(""))
    }

    @Test
    fun testWordsFromGivenFileAreSuccessfullyIgnored() {
        val wordsToIgnore = listOf("the", "abc")
        assertEquals(2, basicWordCounter.count("word the word abc", wordsToIgnore = wordsToIgnore))
    }
}
