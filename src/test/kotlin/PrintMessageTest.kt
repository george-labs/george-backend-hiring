import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.BufferedOutputStream
import java.io.ByteArrayOutputStream

class PrintMessageTest {
    private val outputStream = ByteArrayOutputStream()

    @Test
    fun `prints the message to the provided output stream`() {
        printMessage(MSG, outputStream)
        assertEquals(MSG, String(outputStream.toByteArray()))
    }

    companion object {
        private const val MSG = "Number of words:"
    }
}