import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WordCounterTest {
    val stopWords: List<String> = listOf(
        "the",
        "a",
        "on",
        "off",
    )
    val tested = WordCounter(listOf(NonStopWordsFilter(stopWords), DistinctFilter()))

    @ParameterizedTest
    @CsvSource(
        "'Mary had aa little lamb', 'Mary,had,aa,little,lamb', 'Mary,had,aa,little,lamb'",
        "'Mary . had , \n a % little lamb', 'Mary,had,little,lamb', 'Mary,had,little,lamb'",
        "'Mary 3  had 4  a  little lamb', 'Mary,had,little,lamb', 'Mary,had,little,lamb'",
        "'M4ry 3  had 4  a  little lamb', 'M,ry,had,little,lamb', 'M,ry,had,little,lamb'",
        "'', '', ''",
        "'the a on off NotATheOnOff', 'NotATheOnOff', 'NotATheOnOff'",
        "'1 3 . @ ', '', ''",
        "'Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall', 'Humpty-Dumpty,sat,wall,Humpty-Dumpty,had,great,fall', 'Humpty-Dumpty,sat,wall,had,great,fall'"
    )
    fun countWordsTest(input: String, expectedNonStopWords: String, expectedDistinctNonStopWords: String) {

        val (nonStopWords, distinctNonStopWords) = tested.countWords(input)

        assertEquals(expectedNonStopWords, nonStopWords.joinToString(","))
        assertEquals(expectedDistinctNonStopWords, distinctNonStopWords.joinToString(","))
    }

}