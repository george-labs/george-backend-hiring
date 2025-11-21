import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class WordServiceTest {

    @Test
    fun countWordsValid() {
        val service = WordService()
        assertEquals(1, service.countWords("word"))
        assertEquals(2, service.countWords("word word"))
        assertEquals(3, service.countWords("word w0rd"))
    }

    @Test
    fun countWordsCorner() {
        val service = WordService()
        assertEquals(1, service.countWords(" word "))
        assertEquals(0, service.countWords(" "))
        assertEquals(0, service.countWords(""))
        assertEquals(1, service.countWords("* word "))
    }

    @Test
    fun countWordsWithStopwords() {
        val service = WordService()
        assertEquals(4, service.countWords("Mary had a little lamb"))
    }
}