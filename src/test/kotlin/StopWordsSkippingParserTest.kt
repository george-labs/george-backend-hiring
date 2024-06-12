import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StopWordsSkippingParserTest {
    @Test
    fun `when the file is read then should return correct number of words`() {
        val parser = StopWordsSkippingParser(DEFAULT_STOPWORDS_FILE_NAME)
        assertEquals(4, parser.parse("Mary had a little lamb").count())
    }

    @Test
    fun `when parsing a humpty dumpty then should return correct number of words`() {
        assertEquals(9, StopWordsSkippingParser().parse("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.").count())
    }
}
