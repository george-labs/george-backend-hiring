import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File

private const val FILENAME = "test-mytext.txt"
private const val TEST_CONTENT =
    "Mary had\r\n" +
        "a little\r\n" +
        "lamb"

class FileInputReaderTest {
    @BeforeEach
    fun prepareTestFile() {
        val testFile = File(FILENAME)
        testFile.writeBytes(TEST_CONTENT.toByteArray())
    }

    @AfterEach
    fun deleteTestFile() {
        val testFile = File(FILENAME)
        testFile.delete()
    }

    @Test
    fun `when reading a words file then should `() {
        val reader = FileInputReader(FILENAME)
        assertEquals(TEST_CONTENT, reader.read())
    }
}
