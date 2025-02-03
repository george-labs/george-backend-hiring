import data.WordWrapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import util.isAcceptedWord

class WordWrapperTest {

    private val testingValuePositive = "test"
    private val testingValueHyphenPositive = "test-testing"
    private val testingValueNegative = "t35t"
    private val expectedValuePositive = true
    private val expectedValueNegative = false

    @Test
    fun testWordCounterPositive() {
        val word = WordWrapper(testingValuePositive)
        Assertions.assertEquals(expectedValuePositive, word.isAcceptedWord())
    }

    @Test
    fun testWordCounterHyphenPositive() {
        val word = WordWrapper(testingValueHyphenPositive)
        Assertions.assertEquals(expectedValuePositive, word.isAcceptedWord())
    }

    @Test
    fun testWordCounterNegative() {
        val word = WordWrapper(testingValueNegative)
        Assertions.assertEquals(expectedValueNegative, word.isAcceptedWord())
    }
}