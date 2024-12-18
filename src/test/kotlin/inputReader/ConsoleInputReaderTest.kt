package inputReader

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConsoleInputReaderTest {

    @Test
    fun readsPrintTextAndReadsInputThenReturnsInput() {
        // given
        var printedValue: String? = null
        val valueForInput = "test input text"
        val printer = { value: String -> printedValue = value }
        val reader = { valueForInput }
        val consoleInputReader = ConsoleInputReader(reader, printer)

        // when
        val result = consoleInputReader.read()

        // then
        assertEquals(ConsoleInputReader.entryMessage, printedValue)
        assertEquals(valueForInput, result)
    }
}