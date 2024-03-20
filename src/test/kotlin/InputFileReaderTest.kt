import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.nio.file.Paths
import org.junit.jupiter.api.assertThrows

class InputFileReaderTest {

    private val existingFileName = "test.txt"
    private val nonExistingFileName = "nonexistent.txt"

    @Test
    fun `readText returns correct content for existing file`() {
        val path = Paths.get(ClassLoader.getSystemResource(existingFileName).toURI())
        val expectedContent = path.toFile().readText()

        val inputFileReader = InputFileReader(path.toString())
        val actualContent = inputFileReader.readText()

        assertEquals(expectedContent, actualContent)
    }

    @Test
    fun `readTextFromResources returns correct content for existing resource`() {
        val expectedContent = ClassLoader.getSystemResourceAsStream(existingFileName)?.bufferedReader().use { it?.readText() } ?: ""
        val inputFileReader = InputFileReader(existingFileName)
        val actualContent = inputFileReader.readTextFromResources()

        assertEquals(expectedContent, actualContent)
    }

    @Test
    fun `readText throws IllegalArgumentException for non-existing file`() {
        val inputFileReader = InputFileReader(nonExistingFileName)
        assertThrows<IllegalArgumentException> {
            inputFileReader.readText()
        }
    }

    @Test
    fun `readTextFromResources throws IllegalArgumentException for non-existing resource`() {
        val inputFileReader = InputFileReader(nonExistingFileName)
        assertThrows<IllegalArgumentException> {
            inputFileReader.readTextFromResources()
        }
    }
}
