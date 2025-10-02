import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WordCounterTest {

    private val stopWordsReader = StopWordsReader()
    private val wordCounter = WordCounter(stopWordsReader)

    @Test
    fun `only words containing alphabetical letters are allowed`() {
        assertEquals(1, wordCounter.count("daniel"))
        assertEquals(1, wordCounter.count("maryy"))
        assertEquals(0, wordCounter.count("mar2y"))
        assertEquals(0, wordCounter.count("mar.y"))
        assertEquals(0, wordCounter.count("mary."))
        assertEquals(0, wordCounter.count("----"))
        assertEquals(0, wordCounter.count(""))
    }

    @Test
    fun `words should only be split by whitespaces`() {
        assertEquals(5, wordCounter.count("maryy had two lil lambs"))
        assertEquals(4, wordCounter.count("maryhad one lil lamb"))
        assertEquals(4, wordCounter.count("mar2y had one lil lamb"))
        assertEquals(4, wordCounter.count("mar.y had one lil lamb"))
        assertEquals(0, wordCounter.count("---- ----"))
        assertEquals(0, wordCounter.count("daniel.maryy"))
        assertEquals(0, wordCounter.count(""))
    }

    @Test
    fun `words matching stopwords file are filtered`() {
        assertEquals(3, wordCounter.count("mary had a lil lamb"))
        assertEquals(3, wordCounter.count("maryhad a lil lamb"))
        assertEquals(3, wordCounter.count("daniel is a lamb"))
        assertEquals(4, wordCounter.count("the lamb daniel had was nice"))
        assertEquals(0, wordCounter.count("---- ----"))
        assertEquals(0, wordCounter.count("xxxxx"))
        assertEquals(0, wordCounter.count("daniel.mary"))
        assertEquals(0, wordCounter.count(""))
    }

    @ParameterizedTest
    @CsvSource(value = ["MARY had A lil lamb,3",
        "MARY had A lil lamb,3",
        "mary had A lil lamb,3",
        "maryhad a lil lamb,3",
        "daniel is a lamb,3",
        "the lamb daniel had was nice,5",
        "---- ----,0",
        "xxxxx,1",
        "daniel.mary,0",
        "'',0"
    ])
    fun `words matching stopwords file are filtered regardless of case`(input: String, expected: Int) {

        assertEquals(expected, wordCounter.count(input))

    }


}