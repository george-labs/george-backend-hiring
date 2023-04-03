import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

class WordCounterApplicationKtIntegrationTest {

    private lateinit var systemOut: PrintStream
    private lateinit var systemIn: InputStream

    @BeforeEach
    fun setUp() {
        systemIn = System.`in`
        systemOut = System.`out`
    }

    @AfterEach
    fun tearDown() {
        System.setIn(systemIn)
        System.setOut(systemOut)
    }

    @Test
    fun `should count words`() {
        System.setIn("Hello world I am David".byteInputStream())

        val output = ByteArrayOutputStream().use { bos ->
            PrintStream(bos).use { outputStream ->
                System.setOut(outputStream)

                main(arrayOf())

                outputStream.flush()

            }
            bos.toString()
        }
        assertEquals("Enter text: Number of words: 4\n", output)

    }
}
