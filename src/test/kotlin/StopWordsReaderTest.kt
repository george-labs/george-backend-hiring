import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StopWordsReaderTest {
    private val fileReader = StopWordsReader()

    val STOP_WORDS = setOf("a", "on", "off", "the")

    @Test
    fun testGetStopWordsAsSet() {
        val set = fileReader.getStopWordsAsSet("src/main/resources/stopwords.txt")
        assertEquals(STOP_WORDS, set)
    }
}