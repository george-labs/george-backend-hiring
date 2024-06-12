import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WordsParserTest {
    @Test
    fun `when parsing a chunks of characters separated by whitespace then should return correct number of words`() {
        assertEquals(5, WordsParser().parse("Mary had a little lamb").count())
    }

    @Test
    fun `when parsing a chunks of allowed and disallowed characters separated by whitespace then should return correct number of words`() {
        assertEquals(3, WordsParser().parse("Mary4 had a little lamb.").count())
    }
}
