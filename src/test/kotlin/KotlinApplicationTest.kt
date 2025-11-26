import extensions.countWords
import extensions.getDividedWords
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinApplicationTest {
    val testWords="Mary had a little lamb"

    val notWords="123 )(* +| 45 !"

    val notWordsStop="123 )(* +| 45 ! the"



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

    @Test
    fun testWordCountStopWords(){
        assertEquals(4, testWords.getDividedWords().countWords(FileReader().readStopWords()))
    }

    @Test
    fun testNotWordCountStopWords(){
        assertEquals(0, notWordsStop.getDividedWords().countWords(FileReader().readStopWords()))
    }
}