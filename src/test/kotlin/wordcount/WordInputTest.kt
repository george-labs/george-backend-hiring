package wordcount

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.io.FileNotFoundException

class WordInputTest {

    @Test
    fun `should read input from file`() {
        val input = WordInput.fromFile("mytext.txt")
            .input
            .replace(Regex("[\\r\\n]+"), " ")

        assertEquals("Mary had a little lamb", input)
    }

    @Test
    fun `should throw error if file does not exist`() {
        assertThrows<FileNotFoundException>({ WordInput.fromFile("mytext.txt").input })
    }
}