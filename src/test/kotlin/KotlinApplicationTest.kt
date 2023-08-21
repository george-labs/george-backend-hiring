import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class KotlinApplicationTest {
    @ParameterizedTest
    @CsvSource(
        "      word  word     ,2",
        "word word,2",
        "word.    word,1",
        "word word3    word,2",
        "word3word  word., 0",
        "there are 3    cats,3",
        "please turn on the lights.,2",
        "    the  3lights are turned off and a washing machine.,4"
    )
    fun testWordCount(input: String, expected: Int) {
        val stopWords = listOf("the","a", "on", "off")
        val got = KotlinApplication.wordCount(input, stopWords)
        assert(expected == got) {
            "wordCount: Expected $expected, Got $got"
        }
    }
}