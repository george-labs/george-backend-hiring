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
        assertEquals(
            """
            Enter text: 
            Number of words: 4
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

        // FIXME: no dummy input should be needed here
        runWordCounter(arrayOf(tempFile.absolutePath), StringReader("dummy"), output)

        assertEquals(
            """
        Number of words: 4
        """.trimIndent(), output.toString().trim()
        )
    }

}