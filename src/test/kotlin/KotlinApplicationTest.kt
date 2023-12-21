import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinApplicationTest {
    @Test
    fun `test word count`() {
        val numberOdWords = countWords("Hello world")
        Assertions.assertEquals(2,  numberOdWords)
    }

    @Test
    fun `test incorrect words are skipped`() {
        val numberOdWords = countWords("Hell0 wor1d")
        Assertions.assertEquals(0,  numberOdWords)
    }

    @Test
    fun `test that we skip also words with commas, semicolons, etc`() {
        val numberOdWords = countWords("Hello, world! We: should; skip| this.")
        Assertions.assertEquals(0,  numberOdWords)
    }

    @Test
    fun `test empty string`() {
        val numberOdWords = countWords("")
        Assertions.assertEquals(0,  numberOdWords)
    }
}
