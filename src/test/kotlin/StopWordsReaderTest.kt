import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StopWordsReaderTest{

    private val reader = StopWordsReader()

    @Test
    fun `stopwords resource is included and contains words`(){
        assertNotNull(reader.provide())
        assertTrue(reader.provide().isNotEmpty())
    }
}