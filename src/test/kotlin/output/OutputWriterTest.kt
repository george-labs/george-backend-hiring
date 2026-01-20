package output

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import wordcount.Stopwords
import wordcount.WordCountResult

class OutputWriterTest {

    class TestPrinter(val expected: String) : Printer {
        override fun print(text: String) {
            assertEquals(expected, text)
        }

    }

    @Test
    fun `should print result in correct format`() {
        val result = WordCountResult(10, 5, 4.12345)

        val expectedOutput = "Number of words: 10, unique: 5; average word length: 4.12 characters"

        OutputWriter(TestPrinter(expectedOutput)).writeOutput(result)
    }
}