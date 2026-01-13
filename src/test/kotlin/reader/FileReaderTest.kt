package reader

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

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
    }
}