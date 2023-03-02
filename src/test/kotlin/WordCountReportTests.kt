import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class WordCountReportTests {
    @Test
    fun testToString() {
        Assertions.assertEquals(WordCountReport(14, 10, BigDecimal("5.63")).toString(),
                "Number of words: 14, unique: 10; average word length: 5.63 characters")
    }
}