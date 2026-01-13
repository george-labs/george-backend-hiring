package reader

import exception.FileReaderException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class FileReaderTest {
    private val fileReader = FileReader()

    @Nested
    inner class ReadFileByLine {
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

    @Nested
    inner class ReadFileToString {
        @Test
        fun `readFileToString should read lines from file correctly`() {
            val testFilePath = "src/test/resources/mytext.txt"
            val expected = """
                Mary had
                a little
                lamb
            """.trimIndent()

            val actualLines = fileReader.readFileToString(testFilePath)

            assertEquals(expected, actualLines)
        }

        @Test
        fun `readFileToString should throw an exception when file does not exist`() {
            val testFilePath = "src/test/resources/do_not_exist.txt"

            assertThrows<FileReaderException> {
                fileReader.readFileToString(testFilePath)
            }
        }

        @Test
        @Disabled("Disabled because creating a non-readable file is environment dependent")
        fun `readFileToString should throw exception when file is not readable`() {
            val testFilePath = "src/test/resources/secret_file.txt"

            assertThrows<FileReaderException> {
                fileReader.readFileToString(testFilePath)
            }
        }
    }
}