import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinApplicationTest {

    private val testingValuePositive = "Test testing testo"
    private val testingValueNegative = "t35t 987456 i-o8 i/p"
    private val expectedValuePositive = 3
    private val expectedValueNegative = 0

    @Test
    fun testDummy() {
        assert(value = true)
    }

    @Test
    fun testWordCounterPositive() {
        val counter = WordCounter(testingValuePositive)
        val count = counter.countWords(counter.splitToWords())
        Assertions.assertEquals(expectedValuePositive, count)
    }

    @Test
    fun testWordCounterNegative() {
        val counter = WordCounter(testingValueNegative)
        val count = counter.countWords(counter.splitToWords())
        Assertions.assertEquals(expectedValueNegative, count)
    }
}