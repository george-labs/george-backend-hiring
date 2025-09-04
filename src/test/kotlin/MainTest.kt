import com.erste.interview.runWordCounter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.StringReader
import java.io.StringWriter

class MainTest {

    @Test
    fun `test with command input and output`() {
        val input = StringReader("Mary had a little lamb")
        val output = StringWriter()

        runWordCounter(input, output)

        // assert what in the stream
        assertEquals(
            """
            Enter text: 
            Number of words: 4
        """.trimIndent(), output.toString()
        )
    }

}