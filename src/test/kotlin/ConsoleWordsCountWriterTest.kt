import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ConsoleWordsCountWriterTest {
    private val outContent = ByteArrayOutputStream()
    private val originalOut: PrintStream = System.out

    @BeforeEach
    fun setUpStreams() {
        System.setOut(PrintStream(outContent))
    }

    @AfterEach
    fun restoreStreams() {
        System.setOut(originalOut)
    }

    @Test
    fun `when calling hello() then printer should print correct prompt`() {
        ConsoleWordsCountWriter().write(5)
        assertEquals("Number of words: 5", outContent.toString())
    }
}
