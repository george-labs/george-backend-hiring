package output

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import wordcount.WordCountResult

class OutputWriterTest {

    class TestPrinter : Printer {

        private val output = mutableListOf<String>()

        override fun print(text: String) {
            output.add(text)
        }

        fun assertOutput(expected: List<String>) {
            assertEquals(expected, output)
        }
    }

    @Test
    fun `should print result in correct format`() {
        val result = WordCountResult(10, 5, 4.12345)

        val printer = TestPrinter()

        OutputWriter(printer).writeOutput(result)

        printer.assertOutput(listOf("Number of words: 10, unique: 5; average word length: 4.12 characters"))
    }

    @Test
    fun `should include index in output`() {
        val result = WordCountResult(10, 5, 4.12345, listOf("Mary", "had", "little", "lamb"))

        val printer = TestPrinter()

        OutputWriter(printer).writeOutput(result, includeIndex = true)

        printer.assertOutput(
            listOf(
                "Number of words: 10, unique: 5; average word length: 4.12 characters",
                "Index:",
                "had",
                "lamb",
                "little",
                "Mary"
            )
        )
    }
}