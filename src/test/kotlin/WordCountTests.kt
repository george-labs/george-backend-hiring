import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WordCountTests {
    @Test
    fun wordCountTest() {
       Assertions.assertEquals(5, countWords("Mary had a little lamb"))
       Assertions.assertEquals(5, countWords("Mary had  a little lamb"))
       Assertions.assertEquals(4, countWords("Mary-Ann had a little lamb"))
    }
}