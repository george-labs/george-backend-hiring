import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SimpleWordsParserTest {
    private val underTest = SimpleWordsParser()

    @Test
    fun `when parsing a chunks of characters separated by whitespace then should return correct number of words`() {
        assertEquals(5, underTest.parse("Mary had a little lamb").count())
    }

    @Test
    fun `when parsing a chunks of allowed and disallowed characters separated by whitespace then should return correct number of words`() {
        assertEquals(4, underTest.parse("Mary4 had a little lamb.").count())
    }

    @Test
    fun `when parsing a Humpty-Dumpty`() {
        assertEquals(1, underTest.parse("Humpty-Dumpty").count())
    }

    @Test
    fun `when parsing little dot lamb then should return correct number of words`() {
        assertEquals(2, underTest.parse("little.lamb").count())
    }
}
