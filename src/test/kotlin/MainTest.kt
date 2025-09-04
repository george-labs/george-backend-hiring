import com.erste.interview.runWordCounter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.StringReader
import java.io.StringWriter

class MainTest {

    @Test
    fun `command input`() {
        val input = StringReader("Mary had a little lamb")
        val output = StringWriter()

        runWordCounter(emptyArray<String>(), input, output)

        // assert what in the stream
        // expected avg length: (4 + 3 + 6 + 4) / 4 = 17 / 4 = 4.25
        assertEquals(
            """
            Enter text: 
            Number of words: 4, unique: 4; average word length: 4.25 characters
        """.trimIndent(), output.toString()
        )
    }

    @Test
    fun `input file`() {
        val tempFile = kotlin.io.path.createTempFile().toFile()
        tempFile.deleteOnExit()
        val output = StringWriter()

        tempFile.writeText(
            """
                Mary had
                a little
                lamb
            """.trimIndent()
        )

        runWordCounter(
            args = arrayOf(tempFile.absolutePath),
            input = null,
            output = output,
        )

        // expected avg length: (4 + 3 + 6 + 4) / 4 = 17 / 4 = 4.25
        assertEquals(
            """
        Number of words: 4, unique: 4; average word length: 4.25 characters
        """.trimIndent(), output.toString().trim()
        )
    }

}