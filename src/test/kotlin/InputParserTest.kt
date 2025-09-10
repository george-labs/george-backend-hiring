import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class InputParserTest {
    @Test
    fun `returns an empty list, when input is the empty string`() {
        assertTrue(parseInput("").isEmpty())
    }

    @Test
    fun `returns a single element list, when input is a single word`() {
        assertEquals(listOf(WORD_1), parseInput(WORD_1))
    }

    @Test
    fun `returns a word list, when input has multiple words`() {
        assertEquals(listOf(WORD_1, WORD_2), parseInput("$WORD_1 $WORD_2"))
    }

    @Test
    fun `returns a word list, when input has multiple mixed-case words`() {
        assertEquals(listOf("One", WORD_2), parseInput("One $WORD_2"))
    }

    @Test
    fun `returns a word list, when input has multiple uppercase words`() {
        assertEquals(listOf(WORD_1.uppercase(), WORD_2.uppercase()), parseInput("${WORD_1.uppercase()} ${WORD_2.uppercase()}"))
    }

    @Test
    fun `multiple whitespaces are ignored`() {
        assertEquals(listOf(WORD_1, WORD_2), parseInput("  $WORD_1    $WORD_2  "))
    }

    @Test
    fun `invalid words are ignored`() {
        assertEquals(listOf(WORD_1, WORD_2), parseInput("  $WORD_1  1  $WORD_2  "))
    }

    @Test
    fun `word containing a hyphen is treated as a single word`() {
        assertEquals(listOf("$WORD_1-$WORD_2"), parseInput("$WORD_1-$WORD_2"))
    }

    @Test
    fun `word containing multiple hyphens is treated as an invalid word`() {
        assertEquals(emptyList<String>(), parseInput("$WORD_1-$WORD_2-three"))
    }

    @Test
    fun `returns all words, when input contains simple and hyphened words`() {
        assertEquals(listOf(WORD_1, "$WORD_1-$WORD_2", WORD_2), parseInput("$WORD_1 $WORD_1-$WORD_2 $WORD_2"))
    }

    companion object {
        private const val WORD_1 = "one"
        private const val WORD_2 = "two"
    }
}