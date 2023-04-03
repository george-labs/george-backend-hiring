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
    fun `should count words for input read from stdin`() {
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


    @Test
    fun `should count words for input read from file`() {
        val output = ByteArrayOutputStream().use { bos ->
            PrintStream(bos).use { outputStream ->
                System.setOut(outputStream)

                val inputPath = WordCounterApplicationKtIntegrationTest::class.java.getResource("example_input.txt")?.path ?: error("No resource found!")
                main(arrayOf(inputPath))

                outputStream.flush()

            }
            bos.toString()
        }
        assertEquals("Number of words: 4\n", output)

    }

}
