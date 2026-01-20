package wordcount

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import reader.InputReader

class TestCmdReader : InputReader {
    override fun readInput(): String = "Input from command line"
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

    @ParameterizedTest
    @CsvSource(
        // Should read from a file + index
        "mytext.txt, Mary had a little lamb, false",
        // Should read from a file + index
        "mytext.txt -index, Mary had a little lamb, true",
//        // Unknown file, should fallback to null input
        "unknown.txt, , false",
        // Unknown file, should fallback to null input + index
        "unknown.txt -index, ,true",
        // No argument, should read from command line
        " , Input from command line, false",
        // No argument, should read from command line + index
        "-index, Input from command line, true"
    )
    fun `should parse argument correctly`(
        arguments: String?,
        expectedInput: String?,
        expectedIndexOption: Boolean
    ) {
        val args = arguments?.split(" ")?.toTypedArray() ?: emptyArray()

        val wordInput = WordInput
            .fromArguments(args, TestCmdReader())

        val input = wordInput
            .input
            ?.replace(Regex("[\\r\\n]+"), " ")

        assertEquals(expectedInput, input)
        assertEquals(expectedIndexOption, wordInput.includeIndex)
    }
}

