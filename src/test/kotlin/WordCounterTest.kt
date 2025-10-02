import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WordCounterTest{

    private val wordCounter = WordCounter()

    @Test
    fun `only words containing alphabetical letters are allowed` () {
        assertEquals(1 ,wordCounter.count("daniel"))
        assertEquals(1 ,wordCounter.count("mary"))
        assertEquals(0 ,wordCounter.count("mar2y"))
        assertEquals(0 ,wordCounter.count("mar.y"))
        assertEquals(0 ,wordCounter.count("mary."))
        assertEquals(0, wordCounter.count("----"))
        assertEquals(0, wordCounter.count(""))
    }

    @Test
    fun `words should only be split by whitespaces` () {
        assertEquals(5 ,wordCounter.count("mary had a lil lamb"))
        assertEquals(4 ,wordCounter.count("maryhad a lil lamb"))
        assertEquals(4 ,wordCounter.count("mar2y had a lil lamb"))
        assertEquals(4 ,wordCounter.count("mar.y had a lil lamb"))
        assertEquals(0 ,wordCounter.count("---- ----"))
        assertEquals(0, wordCounter.count("daniel.mary"))
        assertEquals(0, wordCounter.count(""))
    }
}