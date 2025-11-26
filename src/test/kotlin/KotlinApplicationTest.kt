import extensions.countWords
import extensions.getDividedWords
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinApplicationTest {
    val testWords="Mary had a little lamb"

    val notWords="123 )(* +| 45 !"

    @Test
    fun dummyTest(){
        assert("dummy".isNotBlank())
    }

    @Test
    fun testWordCount(){
        assertEquals(5, testWords.getDividedWords().countWords())
    }

    @Test
    fun testNotWordCount(){
        assertEquals(0, notWords.getDividedWords().countWords())
    }
}