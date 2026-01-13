package reader

import exception.FileReaderException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class FileReaderTest {
    private val fileReader = FileReader()

    @Test
    fun `readFileByLine should read lines from file correctly`() {
        val testFilePath = "src/test/resources/stopwords.txt"
        val expectedLines = listOf(
            "the",
            "a",
            "on",
            "off",
        )

        val actualLines = fileReader.readFileByLine(testFilePath)

        assertEquals(expectedLines, actualLines)
    }

    @Test
    fun `readFileByLine should return empty list when file does not exist`() {
        val testFilePath = "src/test/resources/do_not_exist.txt"
        val actualLines = fileReader.readFileByLine(testFilePath)

        assertTrue(actualLines.isEmpty())
    }

    @Test
    fun `readFileByLine should return empty list when filePath is empty`() {
        val testFilePath = "src/test/resources/do_not_exist.txt"
        val actualLines = fileReader.readFileByLine(testFilePath)

        assertTrue(actualLines.isEmpty())
    }

    @Test
    @Disabled("Disabled because creating a non-readable file is environment dependent")
    fun `readFileByLine should throw exception when file is not readable`() {
        val testFilePath = "src/test/resources/secret_file.txt"

        assertThrows<FileReaderException> {
            fileReader.readFileByLine(testFilePath)
        }
    }
}