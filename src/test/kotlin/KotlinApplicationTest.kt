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
        "word3word  word., 0"
    )
    fun testWordCount(input: String, expected: Int) {
        val got = KotlinApplication.wordCount(input)
        assert(expected == got) {
            "wordCount: Expected $expected, Got $got"
        }
    }
}