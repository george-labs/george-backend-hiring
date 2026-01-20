package wordcount

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WordCounterTest {

    @ParameterizedTest
    @CsvSource(
        "Mary had a little lamb, 5",
        "Hello there2w, 3",
        "H1el2lo there2w, 5",
        "H 1 el 2 lo, 3",
        "Helálo hello, 3",
        "He@lo hello, 3",
        "' Hello \n Wor\tld', 3",
        " , 0",
    )
    fun `wordcounter should print correct number of words`(input: String?, expectedWordCount: Int) {
        val wordCounter = WordCounter()

        val res = wordCounter.countWords(input)

        assertEquals(expectedWordCount, res)
    }
}