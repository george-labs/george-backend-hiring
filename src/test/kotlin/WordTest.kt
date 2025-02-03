import data.Word
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WordTest {

    private val testingValuePositive = "test"
    private val testingValueNegative = "t35t"
    private val expectedValuePositive = true
    private val expectedValueNegative = false

    @Test
    fun testWordCounterPositive() {
        val word = Word(testingValuePositive)
        Assertions.assertEquals(expectedValuePositive, word.isWord())
    }

    @Test
    fun testWordCounterNegative() {
        val word = Word(testingValueNegative)
        Assertions.assertEquals(expectedValueNegative, word.isWord())
    }
}