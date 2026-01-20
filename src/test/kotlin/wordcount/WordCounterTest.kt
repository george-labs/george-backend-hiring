package wordcount

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WordCounterTest {

    val stopwords = Stopwords(
        listOf("the", "a", "on", "off")
    )

    @ParameterizedTest
    @CsvSource(
        "Mary had a little lamb, 4",
        "Hello there2w, 3",
        "H1el2lo there2w, 5",
        "H 1 el 2 lo, 3",
        "Helálo hello, 3",
        "He@lo hello, 3",
        "' Hello \n Wor\tld', 3",
        " , 0",
    )
    fun `wordcounter should print correct number of words`(input: String?, expectedWordCount: Int) {
        val wordCounter = WordCounter(stopwords)

        val res = wordCounter.countWords(input)

        assertEquals(expectedWordCount, res.numWords)
    }

    @ParameterizedTest
    @CsvSource(
        delimiter = '|',
        value = [
            "a,the,hello,mary | 3",
            "a | 5",
            "fuu,bla | 6"
        ]
    )
    fun `wordcounter should exclude stopwords`(stopwords: String, expectedWordCount: Int) {
        val stopwordsSet = stopwords.split(",").map { it.trim() }

        val wordCounter = WordCounter(Stopwords(stopwordsSet))

        val res = wordCounter.countWords("Hello Mary had a little lamb")

        assertEquals(expectedWordCount, res.numWords)
    }

    @Test
    fun `wordcounter should return both unique and total word count`() {
        val wordCounter = WordCounter(stopwords)

        val res = wordCounter.countWords("Humpty-Dumpty sat on a wall. Humpty-DUMPTY had a great fall")

        assertEquals(9, res.numWords)
        assertEquals(7, res.unique)
    }

    @Test
    fun `wordcounter should not split words on hyphen`() {
        val config = WordCounterConfig("[^A-Za-z-]+")
        val wordCounter = WordCounter(stopwords, config)

        val res = wordCounter.countWords("Humpty-Dumpty sat on a wall. Humpty-DUMPTY had a great fall")

        assertEquals(7, res.numWords)
        assertEquals(6, res.unique)
    }

    @CsvSource(
        "Mary had a littl, 4.0",
        "Mary had a little lamb, 4.25"
    )
    @ParameterizedTest
    fun `wordcounter should calculate average word length`(input: String, expectedWordLength: Double) {
        val wordCounter = WordCounter(stopwords)

        val res = wordCounter.countWords(input)

        assertEquals(expectedWordLength, res.averageLength)
    }

}