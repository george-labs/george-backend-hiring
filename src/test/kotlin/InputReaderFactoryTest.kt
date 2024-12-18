import inputReader.ConsoleInputReader
import inputReader.FileInputReader
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InputReaderFactoryTest {
    private val printer = { _: String ->  }
    private val reader = { "test input text" }
    private val inputReaderFactory = InputReaderFactory(reader, printer)

    @Test
    fun whenFileNameIsNotNullReturnFileInputReader() {
        // given
        // when
        val result = inputReaderFactory.getInputReader("notNullFileName")

        // then
        assertEquals(FileInputReader::class, result::class)
    }

    @Test
    fun whenFileNameIsNullReturnConsoleInputReader() {
        // given
        // when
        val result = inputReaderFactory.getInputReader(null)

        // then
        assertEquals(ConsoleInputReader::class, result::class)
    }
}
