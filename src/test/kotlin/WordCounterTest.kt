import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WordCounterTest {

    private val fileName = "stopwords.txt"
    private val stopWordsReader = StopWordsReader(fileName)
    private val wordCounter = WordCounter(stopWordsReader)

    @ParameterizedTest
    @CsvSource(value = [
        "daniel,1",
        "marry,1",
        "mar2y,0",
        "mar.y,0",
        "mary.,0",
        "---,0",
        "'',0"
    ])
    fun `only words containing alphabetical letters are allowed`() {
        assertEquals(1, wordCounter.count("daniel"))
        assertEquals(1, wordCounter.count("maryy"))
        assertEquals(0, wordCounter.count("mar2y"))
        assertEquals(0, wordCounter.count("mar.y"))
        assertEquals(0, wordCounter.count("mary."))
        assertEquals(0, wordCounter.count("----"))
        assertEquals(0, wordCounter.count(""))
    }

    @ParameterizedTest
    @CsvSource(value = [
        "maryy had two lil lambs,5",
        "maryhad one lil lamb,4",
        "mar2y had one lil lamb,4",
        "mar.y had one lil lamb,4",
        "---- ----,0",
        "daniel.maryy,0",
        "'',0"
    ])
    fun `words should only be split by whitespaces`(input: String, expected: Int) {
        assertEquals(expected, wordCounter.count(input))
    }

    @ParameterizedTest
    @CsvSource(value = [
        "mary had a lil lamb,3",
        "maryhad a lil lamb,3",
        "daniel is a lamb,3",
        "maryhad a lil lamb,3",
        "the lamb daniel had was nice,5",
        "---- ---,0",
        "xxxxx,1",
        "daniel.mary,0",
        "'',0"
    ])
    fun `words matching stopwords file are filtered`(input: String, expected: Int) {
        assertEquals(expected, wordCounter.count(input))
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