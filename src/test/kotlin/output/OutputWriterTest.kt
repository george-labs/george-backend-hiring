package output

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import wordcount.WordCountResult

class OutputWriterTest {

    class TestPrinter(val expected: String) : Printer {

        private val output = mutableListOf<String>()

        override fun print(text: String) {
            assertEquals(expected, text)
        }

        fun assertOutput() {
            assertEquals(expected, output)
        }
    }

    @Test
    fun `should print result in correct format`() {
        val result = WordCountResult(10, 5, 4.12345)

        val expectedOutput = "Number of words: 10, unique: 5; average word length: 4.12 characters"

        OutputWriter(TestPrinter(expectedOutput)).writeOutput(result)
    }

    @Test
    fun `should include index in output`() {
        val result = WordCountResult(10, 5, 4.12345, listOf("Mary", "had", "little", "lamb"))

        val expectedOutput = """Number of words: 10, unique: 5; average word length: 4.12 characters
            |Index:
            |had
            |lamb
            |little
            |Mary
        """.trimMargin()

        OutputWriter(TestPrinter(expectedOutput)).writeOutput(result, includeIndex = true)
    }
}