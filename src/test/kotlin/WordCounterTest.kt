import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WordCounterTest {
    private val wordCounter = WordCounter()

    @Test
    fun countReturnZeroWhenInputIsEmpty() {
        // given
        val input = ""

        // when
        val result = wordCounter.count(input)

        // then
        assertEquals(0, result)
    }

    @Test
    fun countReturnZeroWhenInputIsBlank() {
        // given
        val input = "       "

        // when
        val result = wordCounter.count(input)

        // then
        assertEquals(0, result)
    }

    @Test
    fun countIgnoresNoneAlphabeticalValues() {
        // given
        val input = "9999 /// ---- !@#$%^&*("

        // when
        val result = wordCounter.count(input)

        // then
        assertEquals(0, result)
    }

    @Test
    fun countReturnsValidResultOnNormalInput() {
        // given
        val input = "Ma99ry had a little lamb 999"

        // when
        val result = wordCounter.count(input)

        // then
        assertEquals(4, result)
    }

    @Test
    fun countHandlesMultipleWhiteSpaceAfterEachOther() {
        // given
        val input = "had      a little"

        // when
        val result = wordCounter.count(input)

        // then
        assertEquals(3, result)
    }

}