package at.erste.io

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class InputReaderFactoryTest {
    val inputReaderFactory = InputReaderFactory()

    @Test
    fun testCreateConsoleReader() {
        val reader = inputReaderFactory.createInputReader(null)
        assertTrue(reader is ConsoleInputReader)
    }

    @Test
    fun testCreateFileReader() {
        val reader = inputReaderFactory.createInputReader("any_file_name.txt")
        assertTrue(reader is FileInputReader)
    }
}
