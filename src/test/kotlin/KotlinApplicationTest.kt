import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinApplicationTest {
    @Test
    fun `test word count`() {
        val numberOdWords = countWords("Hello world")
        Assertions.assertEquals(2,  numberOdWords)
    }
}
