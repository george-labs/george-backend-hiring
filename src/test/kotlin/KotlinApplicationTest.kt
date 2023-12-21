import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinApplicationTest {
    @Test
    fun `test word count`() {
        val numberOfWords = countWords("Hello world")
        Assertions.assertEquals(2,  numberOfWords)
    }

    @Test
    fun `test incorrect words are skipped`() {
        val numberOfWords = countWords("Hell0 wor1d")
        Assertions.assertEquals(0,  numberOfWords)
    }

    @Test
    fun `test that we skip also words with commas, semicolons, etc`() {
        val numberOfWords = countWords("Hello, world! We: should; skip| this.")
        Assertions.assertEquals(0,  numberOfWords)
    }

    @Test
    fun `test empty string`() {
        val numberOfWords = countWords("")
        Assertions.assertEquals(0,  numberOfWords)
    }

    @Test
    fun `test that words containing numbers or separators with space after at the end of the string are not counted`() {
        var numberOfWords = countWords("qwwq4 ")
        Assertions.assertEquals(0,  numberOfWords)
        numberOfWords = countWords("qwwqwerrw,  ")
        Assertions.assertEquals(0,  numberOfWords)
    }

    @Test
    fun `test stop words are taken into account`() {
        val stopWords = listOf("a", "the", "an")
        val numberOfWords = countWords("A quick brown fox jumps over the lazy dog", stopWords)

        Assertions.assertEquals(8,  numberOfWords)
    }
}
