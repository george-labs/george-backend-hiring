import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WordCounterTest {
    private val emptyStopWords = emptySet<String>()

    @Test
    fun countReturnZeroWhenInputIsEmpty() {
        // given
        val wordCounter = WordCounter(emptyStopWords)
        val input = ""

        // when
        val result = wordCounter.countWordsInText(input)

        // then
        assertEquals(0, result)
    }

    @Test
    fun countReturnZeroWhenInputIsBlank() {
        // given
        val wordCounter = WordCounter(emptyStopWords)
        val input = "       "

        // when
        val result = wordCounter.countWordsInText(input)

        // then
        assertEquals(0, result)
    }

    @Test
    fun countIgnoresNoneAlphabeticalValues() {
        // given
        val wordCounter = WordCounter(emptyStopWords)
        val input = "9999 /// ---- !@#$%^&*("

        // when
        val result = wordCounter.countWordsInText(input)

        // then
        assertEquals(0, result)
    }

    @Test
    fun countReturnsValidResultOnNormalInput() {
        // given
        val wordCounter = WordCounter(emptyStopWords)
        val input = "Ma99ry had a little lamb 999"

        // when
        val result = wordCounter.countWordsInText(input)

        // then
        assertEquals(4, result)
    }

    @Test
    fun countHandlesMultipleWhiteSpaceAfterEachOther() {
        // given
        val wordCounter = WordCounter(emptyStopWords)
        val input = "had      a little"

        // when
        val result = wordCounter.countWordsInText(input)

        // then
        assertEquals(3, result)
    }

    @Test
    fun countUsesStopWordsToInvalidateWords() {
        // given
        val stopWords = setOf("a", "on", "off")
        val wordCounter = WordCounter(stopWords)
        val input = "had      a little on off bagel"

        // when
        val result = wordCounter.countWordsInText(input)

        // then
        assertEquals(3, result)
    }

}