import at.erste.ListFileReader
import at.erste.io.TestOutputWriter
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class KotlinApplicationTest {
    val fileReader = ListFileReader().apply {
        lines = listOf("the", "a", "on", "off")
    }

    val outputWriter = TestOutputWriter()

    @Test
    fun testProcessUserInput() {
        val application = KotlinApplication(fileReader, outputWriter)
        application.processUserInput("dummy")
        assertEquals("Number of words: 1", outputWriter.output)
    }
}
