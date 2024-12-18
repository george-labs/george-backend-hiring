package inputReader

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FileInputReaderTest {

    @Test
    fun readReturnsTheWholeContentOfTheProvidedFile() {
        // given
        val textFilePath = "src/test/resources/NormalInputText.txt"
        val reader = FileInputReader(textFilePath)

        // when
        val result = reader.read()

        // then
        val expected = listOf("Mary had", "a little", "lamb").joinToString("\n")
        assertEquals(expected, result)
    }

    @Test
    fun readReturnsEmptyStringInCaseOfEmptyFile() {
        val textFilePath = "src/test/resources/EmptyInputText.txt"
        val reader = FileInputReader(textFilePath)

        // when
        val result = reader.read()

        // then
        val expected = ""
        assertEquals(expected, result)
    }

    @Test
    fun readReturnsEmptyStringInCaseOfBlankFile() {
        val textFilePath = "src/test/resources/BlankInputText.txt"
        val reader = FileInputReader(textFilePath)

        // when
        val result = reader.read()

        // then
        val expected = ""
        assertEquals(expected, result)
    }
}