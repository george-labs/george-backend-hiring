import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StopWordsSkippingParserTest {
    @Test
    fun `when the file is read then should return correct number of words`() {
        val parser = StopWordsSkippingParser(DEFAULT_STOPWORDS_FILE_NAME)
        assertEquals(4, parser.parse("Mary had a little lamb").count())
    }
}
