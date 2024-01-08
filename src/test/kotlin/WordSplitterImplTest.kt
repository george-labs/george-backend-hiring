import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class WordSplitterImplTest {

    private lateinit var basicWordCounter: WordSplitterImpl

    @BeforeEach
    fun setUp() {
        basicWordCounter = WordSplitterImpl()
    }

    @Test
    fun testWordsWithAlphaCharactersOnly() {
        assertEquals(listOf("word", "word", "word"), basicWordCounter.split("word word word"))
    }

    @Test
    fun testWordsWithAlphaCharactersAndSpacesBeforeAndAfter() {
        assertEquals(listOf("word", "word", "word"), basicWordCounter.split("     word word word     "))
    }

    @Test
    fun testWordsWithNonAlphaCharacters() {
        assertEquals(listOf("word", "word", "word"), basicWordCounter.split("word w1o2r3d word word,"))
    }

    @Test
    fun testWordsContainingOnlyNonAlphaCharacters() {
        assertEquals(listOf("word", "word"), basicWordCounter.split("word word. *&!"))
    }

    @Test
    fun testEmptyWords() {
        assertEquals(emptyList(), basicWordCounter.split(""))
    }

    @Test
    fun testWordsFromGivenFileAreSuccessfullyIgnored() {
        val wordsToIgnore = listOf("the", "abc")
        assertEquals(listOf("word", "word"), basicWordCounter.split("word the word abc", wordsToIgnore = wordsToIgnore))
    }
}
