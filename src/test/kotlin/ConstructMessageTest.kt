import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConstructMessageTest {
    @Test
    fun `constructs the output message containing the word count`() {
        val expectedCount = 10
        assertEquals("$MSG $expectedCount", constructMessage(expectedCount))
    }

    companion object {
        private const val MSG = "Number of words:"
    }
}