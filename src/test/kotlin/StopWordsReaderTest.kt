import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StopWordsReaderTest {

    private val fileName = "stopwords.txt"

    @Test
    fun `stopwords resource is included and contains words`() {
        val reader = StopWordsReader(fileName)
        assertNotNull(reader.provide())
        assertTrue(reader.provide().isNotEmpty())
    }

    @Test
    fun `if stopwords resource is not included throws exception`() {
        val reader = StopWordsReader("xxx")
        assertThrows<IllegalArgumentException> {
            reader.provide()
        }
    }


}