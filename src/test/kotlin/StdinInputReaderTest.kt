import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

class StdinInputReaderTest{

    private val reader = StdinInputReader()

    @Test
    fun `input should be read as output`() {
        val input = "Mary had a lil lamb"
        val inputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)
        assertEquals(input, reader.read())
    }

    @Test
    fun `empty input should be read as output`() {
        val input = ""
        val inputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)
        assertEquals(input, reader.read())
    }

}