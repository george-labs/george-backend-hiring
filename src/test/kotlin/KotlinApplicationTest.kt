import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinApplicationTest {

    private val expectedStopwords = listOf("the", "a", "on", "off")

    @Test
    fun `ensure that the stopwords are loaded in memory`() {
        assertEquals(expectedStopwords, stopwords)
    }
}