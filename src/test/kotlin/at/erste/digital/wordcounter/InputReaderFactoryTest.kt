package at.erste.digital.wordcounter

import at.erste.digital.wordcounter.input.FileInputReader
import at.erste.digital.wordcounter.input.InputReaderFactory
import at.erste.digital.wordcounter.input.StandardInputReader
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputReaderFactoryTest {

    @Test
    fun `should return standard input reader`() {
        assertTrue(InputReaderFactory.getInputReaderBasedOnArguments(emptyArray()) is StandardInputReader)
    }

    @Test
    fun `should return file input reader`() {
        assertTrue(InputReaderFactory.getInputReaderBasedOnArguments(arrayOf("test.txt")) is FileInputReader)
    }

    @Test
    fun `should throw exception`() {
        assertThrows<RuntimeException> { InputReaderFactory.getInputReaderBasedOnArguments(arrayOf("fafwa", "fawa")) }
    }

}