package at.erste.digital.wordcounter.input

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FileInputReaderTest {

    @Test
    fun `should return string from file`() {
        //GIVEN
        val fileName = "src/test/resources/words.txt"
        val fileInputReader = FileInputReader(fileName = fileName)

        //WHEN
        val result = fileInputReader.readWords().getOrThrow()

        //THEN
        assertEquals("ana has a dog", result)
    }

}