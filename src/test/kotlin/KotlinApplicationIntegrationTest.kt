import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class KotlinApplicationIntegrationTest {
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
    fun `some dummy test should pass`() {
        assertTrue(true)
    }

    @Test
    fun `when application starts with no input, then should exit`() {
        val application =
            KotlinApplication(
                PromptPrinter(),
                ConsoleInputReader(),
                WordsParser(),
                ConsoleWordsCountWriter(),
            )

        application.run()
    }
}
