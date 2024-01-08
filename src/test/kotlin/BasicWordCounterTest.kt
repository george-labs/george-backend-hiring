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
        assertEquals(listOf("word", "word", "word"), basicWordCounter.count("word word word"))
    }

    @Test
    fun testWordsWithAlphaCharactersAndSpacesBeforeAndAfter() {
        assertEquals(listOf("word", "word", "word"), basicWordCounter.count("     word word word     "))
    }

    @Test
    fun testWordsWithNonAlphaCharacters() {
        assertEquals(listOf("word", "word", "word"), basicWordCounter.count("word w1o2r3d word word,"))
    }

    @Test
    fun testWordsContainingOnlyNonAlphaCharacters() {
        assertEquals(listOf("word", "word"), basicWordCounter.count("word word. *&!"))
    }

    @Test
    fun testEmptyWords() {
        assertEquals(emptyList(), basicWordCounter.count(""))
    }

    @Test
    fun testWordsFromGivenFileAreSuccessfullyIgnored() {
        val wordsToIgnore = listOf("the", "abc")
        assertEquals(listOf("word", "word"), basicWordCounter.count("word the word abc", wordsToIgnore = wordsToIgnore))
    }
}
