package wordcount

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import reader.InputReader

class TestCmdReader : InputReader {
    override fun readInput(): String? = "Input from command line"
}

class WordInputTest {

    @ParameterizedTest
    @CsvSource(
        // Should read from a file
        "mytext.txt, Mary had a little lamb",
        // Unknown file, should fallback to null input
        "unknown.txt, ",
        // No argument, should read from command line
        ", Input from command line"
    )
    fun `should read input based on argument`(argument: String?, expected: String?) {
        val input = WordInput
            .fromFileOrCmd(argument, TestCmdReader())
            .input
            ?.replace(Regex("[\\r\\n]+"), " ")

        assertEquals(expected, input)
    }
}


