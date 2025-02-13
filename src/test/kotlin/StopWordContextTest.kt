import impl.StopWordContext
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StopWordContextTest {

    @Test
    fun `File loader test`() {
        val stopwords = StopWordContext().getStopWords().toList()

        assertEquals(stopwords.size, 4)
        assertEquals(stopwords[0], "the")
        assertEquals(stopwords[1], "a")
        assertEquals(stopwords[2], "on")
        assertEquals(stopwords[3], "off")
    }
}