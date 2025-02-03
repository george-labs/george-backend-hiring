import org.junit.jupiter.api.Test

class KotlinApplicationTest {

    val testingValue = "Test testing testo"
    val testingValueNegative = "t35t 987456 i-o8 i/p"

    @Test
    fun testDummy() {
        assert(value = true)
    }

    @Test
    fun testWordCounter() {
        val counter = WordCounter(testingValue)
        assert(counter.countWords(counter.splitToWords()) == 3)
    }

    @Test
    fun testWordCounterNegative() {
        val counter = WordCounter(testingValueNegative)
        assert(counter.countWords(counter.splitToWords()) == 0)
    }
}