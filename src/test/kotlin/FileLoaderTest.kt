import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FileLoaderTest {

    @Test
    fun `File loader test`() {
        val file = FileLoader.readResourceFile("stopwords.txt")
        val stopwords = FileLoader.parseStopwordsFile(file)

        assertEquals(stopwords.size, 4)
        assertEquals(stopwords[0], "the")
        assertEquals(stopwords[1], "a")
        assertEquals(stopwords[2], "on")
        assertEquals(stopwords[3], "off")
    }
}