package at.erste.digital.wordcounter.input

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FileInputReaderTest {

    @Test
    fun `should return string from file`() {
        //GIVEN
        val fileInputReader = FileInputReader(fileName = "src/test/kotlin/at/erste/digital/wordcounter/words.txt")

        //WHEN
        val result = fileInputReader.readWords().getOrThrow()

        //THEN
        assertEquals("ana has a dog", result)
    }

}