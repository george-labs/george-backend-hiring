import at.erste.io.ListFileReader
import at.erste.io.TestInputReader
import at.erste.io.TestOutputWriter
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class KotlinApplicationTest {
    val fileReader = ListFileReader().apply {
        lines = listOf("the", "a", "on", "off")
    }

    val outputWriter = TestOutputWriter()
    val inputReader = TestInputReader().apply {
        input = "Mary had a little lamb"
    }

    @Test
    fun testProcessUserInput() {
        val application = KotlinApplication(inputReader, fileReader, outputWriter)
        application.processUserInput()
        assertEquals("Number of words: 4", outputWriter.output)
    }

    @Test
    fun testProcessUserInputFile() {
        val application = KotlinApplication(inputReader, fileReader, outputWriter)
        application.processUserInput()
        assertEquals("Number of words: 4", outputWriter.output)
    }
}
