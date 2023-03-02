import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WordCountTests {
    @Test
    fun `wordCount without stop words`() {
       Assertions.assertEquals(5, countWords("Mary had a little lamb", listOf()))
       Assertions.assertEquals(5, countWords("Mary had  a little lamb", listOf()))
       Assertions.assertEquals(4, countWords("Mary-Ann had a little lamb", listOf()))
    }

    @Test
    fun `wordCount with stop words`() {
       Assertions.assertEquals(4, countWords("Mary had a little lamb", listOf("a", "of", "the")))
    }
}