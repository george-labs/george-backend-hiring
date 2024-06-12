import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.InputStream

private const val TEST_INPUT = "Whatever input"

class ConsoleInputReaderTest {
    private val inContent = ByteArrayInputStream(TEST_INPUT.toByteArray())
    private val originalIn: InputStream? = System.`in`

    @BeforeEach
    fun setUpStreams() {
        System.setIn(inContent)
    }

    @AfterEach
    fun restoreStreams() {
        System.setIn(originalIn)
    }

    @Test
    fun `when calling hello() then printer should print correct prompt`() {
        assertEquals(TEST_INPUT, ConsoleInputReader().read())
    }
}
