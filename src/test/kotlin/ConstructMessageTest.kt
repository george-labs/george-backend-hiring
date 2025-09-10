import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConstructMessageTest {
    @Test
    fun `constructs the output message containing the word count and unique count`() {
        assertEquals(MSG, constructMessage(wordCount, uniqueCount))
    }

    companion object {
        private const val wordCount = 10
        private const val uniqueCount = 7
        private const val MSG = "Number of words: $wordCount, unique: $uniqueCount"
    }
}