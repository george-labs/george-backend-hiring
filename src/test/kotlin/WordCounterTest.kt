import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WordCounterTest {

    private val fileName = "stopwords.txt"
    private val stopWordsReader = StopWordsReader(fileName)
    private val wordCounter = WordCounter(stopWordsReader)

    @ParameterizedTest
    @CsvSource(
        value = [
            "daniel,1",
            "marry,1",
            "mar2y,0",
            "mar.y,0",
            "mary.,1",
            "xxxxx,1",
            "---,0",
            "'',0"
        ]
    )
    fun `words containing alphabetical letters are allowed and optional a dot at the end`(
        input: String,
        expected: Int
    ) {
        assertEquals(expected, wordCounter.count(input).filteredCount)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "maryy had two lil lambs,5",
            "maryhad one lil lamb,4",
            "mary-had one lil lamb,4",
            "mary-had one lil lamb,4",
            "maryhad one lil lamb,4",
            "mar2y had one lil lamb,4",
            "mar.y had one lil lamb,4",
            "daniel-had one lil lamb,4",
            "daniel-had one lil daniel,4",
            "daniel\thad one lil lamb,5",
            "daniel\rhad one lil lamb,5",
            "daniel      xx,2",
            "daniel      daniel,2",
            "---- ----,0",
            "daniel.maryy,0",
            "'',0"
        ]
    )
    fun `words should only be split by whitespaces`(
        input: String,
        expected: Int
    ) {
        assertEquals(expected, wordCounter.count(input).filteredCount)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "mary had a lil lamb,3",
            "maryhad a lil lamb,3",
            "daniel is a lamb,3",
            "maryhad a lil lamb,3",
            "the lamb daniel had was nice,5",
            "daniel mary,1",
            "mary mary,0",
        ]
    )
    fun `words matching stopwords file are filtered`(input: String, expected: Int) {
        assertEquals(expected, wordCounter.count(input).filteredCount)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "MARY had A lil lamb,3",
            "MARY had A lil lamb,3",
            "mary had A lil lamb,3",
            "maryhad a lil lamb,3",
            "daniel is a lamb,3",
            "the lamb daniel had was nice,5",
        ]
    )
    fun `words matching stopwords file are filtered regardless of case sensitivity`(
        input: String,
        expected: Int
    ) {
        assertEquals(expected, wordCounter.count(input).filteredCount)
    }


    @ParameterizedTest
    @CsvSource(
        value = [
            "mary mary,0",
            "daniel daniel,1",
            "daniel. daniel.,1",
            "daniel. daniel,2",
            "-- --,0",
            "da-niel,1",
            "da-niel daniel,2"
        ]
    )
    fun `words having the same chars should be counted as unique `(input: String, expected: Int) {
        assertEquals(expected, wordCounter.count(input).uniqueFilteredCount)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "a-a,1",
            "a--,0",
            "-a,0",
            "dan-iel daniel,2",
            "-- --,0",
            "daniel-daxx,1",
            "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.,7"
        ]
    )
    fun `words containing a hyphen should count as one word`(input: String, expected: Int) {
        assertEquals(expected, wordCounter.count(input).filteredCount)
    }



}