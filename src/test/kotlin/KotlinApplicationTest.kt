import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream

class KotlinApplicationTest {

    private val bytearrayOutStream = ByteArrayOutputStream()

    @Test
    fun `returns the input that the user provided`() {
        val input = "Mary had a little lamb"

        assertEquals(input, readInput(bytearrayOutStream) { input })
        assertEquals("Enter text: ", String(bytearrayOutStream.toByteArray()))

    }

    @Test
    fun `can support an empty string input`() {
        assertTrue(readInput(bytearrayOutStream) { "" }.isEmpty())
        assertEquals("Enter text: ", String(bytearrayOutStream.toByteArray()))

    }
}