import interfaces.WordCountInterface
import model.WordCount
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import service.WordCountService
import java.io.File

class WordCountIteration1Test {

    val counter: WordCountInterface = WordCountService(File.createTempFile("stopwords", ".txt"))

    @Test
    fun `given emptyString when count then returnsEmptyList`() {
        val emptySet = counter.count("")
        assertTrue(emptySet.isEmpty())
    }


    @Test
    fun `given mixedCaseWords when count then countsAllAsLowercase`() {
        val result = counter.count("dog Dog DOG")
        assertEquals(listOf(WordCount("dog", 3)), result)
    }


    @Test
    fun `given sampleText when count then returnsCorrectCounts`() {
        val result = counter.count("Mary had a little lamb")
        assertEquals(
            listOf(
                WordCount("mary", 1),
                WordCount("had", 1),
                WordCount("a", 1),
                WordCount("little", 1),
                WordCount("lamb", 1),
            ), result
        )
    }

}