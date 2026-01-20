package wordcount

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StopwordsTest {

    @ParameterizedTest
    @CsvSource(
        "mary, true",
        "MARy, true",
        " the , true",
        "Hello, false",
        "HelloMARY, false",
        " , false",
    )
    fun `isStopword should mark word correctly`(word: String?, expected: Boolean) {
        val words = listOf(
            "Mary",
            " the",
            "a "
        )

        val stopwords = Stopwords(words)
        val res = stopwords.isStopword(word)

        assertEquals(expected, res)
    }

    @Test
    fun `should consider all words if a file can not be read`() {
        val stopwords = Stopwords.fromResource("unknown-file")

        assertFalse(stopwords.isStopword("a"))
        assertFalse(stopwords.isStopword("the"))
    }
}