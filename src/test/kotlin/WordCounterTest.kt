import mocks.InputReaderMock
import mocks.StopWordLoaderMock
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WordCounterTest {

    @Test
    fun countReturnZeroWhenInputIsEmpty() {
        // given
        val stopWorldLoaderMock = StopWordLoaderMock(emptySet())
        val input = ""
        val inputReaderMock = InputReaderMock(input)
        val wordCounter = WordCounter(stopWorldLoaderMock, inputReaderMock)

        // when
        val result = wordCounter.countWordsInText()

        // then
        assertEquals(0, result)
    }

    @Test
    fun countReturnZeroWhenInputIsBlank() {
        // given
        val input = "       "
        val stopWorldLoaderMock = StopWordLoaderMock(emptySet())
        val inputReaderMock = InputReaderMock(input)
        val wordCounter = WordCounter(stopWorldLoaderMock, inputReaderMock)

        // when
        val result = wordCounter.countWordsInText()

        // then
        assertEquals(0, result)
    }

    @Test
    fun countIgnoresNoneAlphabeticalValues() {
        // given
        val input = "9999 /// ---- !@#$%^&*("
        val stopWorldLoaderMock = StopWordLoaderMock(emptySet())
        val inputReaderMock = InputReaderMock(input)
        val wordCounter = WordCounter(stopWorldLoaderMock, inputReaderMock)

        // when
        val result = wordCounter.countWordsInText()

        // then
        assertEquals(0, result)
    }

    @Test
    fun countReturnsValidResultOnNormalInput() {
        // given
        val input = "Ma99ry had a little lamb 999"
        val stopWorldLoaderMock = StopWordLoaderMock(emptySet())
        val inputReaderMock = InputReaderMock(input)
        val wordCounter = WordCounter(stopWorldLoaderMock, inputReaderMock)

        // when
        val result = wordCounter.countWordsInText()

        // then
        assertEquals(4, result)
    }

    @Test
    fun countHandlesTabs() {
        // given
        val input = "had\ta little"
        val stopWorldLoaderMock = StopWordLoaderMock(emptySet())
        val inputReaderMock = InputReaderMock(input)
        val wordCounter = WordCounter(stopWorldLoaderMock, inputReaderMock)

        // when
        val result = wordCounter.countWordsInText()

        // then
        assertEquals(3, result)
    }

    @Test
    fun countHandlesLineSeparators() {
        // given
        val input = "had${System.lineSeparator()}a ${System.lineSeparator()}little"
        val stopWorldLoaderMock = StopWordLoaderMock(emptySet())
        val inputReaderMock = InputReaderMock(input)
        val wordCounter = WordCounter(stopWorldLoaderMock, inputReaderMock)

        // when
        val result = wordCounter.countWordsInText()

        // then
        assertEquals(3, result)
    }

    @Test
    fun countUsesStopWordsToInvalidateWords() {
        // given
        val stopWords = setOf("a", "on", "off")
        val input = "had      a little on off bagel"
        val stopWorldLoaderMock = StopWordLoaderMock(stopWords)
        val inputReaderMock = InputReaderMock(input)
        val wordCounter = WordCounter(stopWorldLoaderMock, inputReaderMock)

        // when
        val result = wordCounter.countWordsInText()

        // then
        assertEquals(3, result)
    }

}