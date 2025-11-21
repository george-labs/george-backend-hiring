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

    @Test
    fun countUnique() {
        val service = WordService()
        assertEquals(7, service.countUnique("Humpty Dumpty sat on a wall. Humpty Dumpty had a great fall."))
    }

    @Test
    fun countWithHyphens() {
        val service = WordService()
        val input = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."
        assertEquals(7, service.countWords(input))
        assertEquals(6, service.countUnique(input))

        assertEquals(2, service.countWords("some - text"))
        assertEquals(2, service.countUnique("some - text"))

        assertEquals(1, service.countWords("-word "))
        assertEquals(1, service.countWords("-word-"))
        assertEquals(0, service.countUnique(" - "))
    }

    @Test
    fun countAverageLength() {
        val service = WordService()
        assertEquals(0F, service.countAverageLength(""))
        assertEquals(0F, service.countAverageLength(" - "))
        assertEquals(3F, service.countAverageLength("test te"))
        assertEquals(4F, service.countAverageLength("test test test"))
        assertEquals(6.428571F, service.countAverageLength("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."))
    }

    @Test
    fun getIndexNoDictionary() {
        val service = WordService()
        val results = service.getIndex("test aaa ff", null)
        assertEquals(3, results.size)
        assertEquals(true, results.containsAll(listOf("test", "aaa", "ff")))
    }

    @Test
    fun getIndexWithDictionary() {
        val service = WordService()
        val results = service.getIndex("test small little", "src/test/resources/dict.txt")
        assertEquals(3, results.size)
        assertEquals(true, results.containsAll(listOf("test*", "small", "little")))
    }

    @Test
    fun getIndexWithEmptyDictionary() {
        val service = WordService()
        val results = service.getIndex("test small little", "src/test/resources/dict_empty.txt")
        assertEquals(3, results.size)
        assertEquals(true, results.containsAll(listOf("test*", "small*", "little*")))
    }
}