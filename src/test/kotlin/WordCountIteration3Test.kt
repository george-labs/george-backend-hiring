import interfaces.WordCountInterface
import model.WordCount
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import service.WordCountService
import java.io.File

class WordCountIteration3Test {

    private fun tempFileCreation(words: List<String>): File {
        val tempFile = File.createTempFile("stopwords", ".txt")
        tempFile.writeText(words.joinToString("\n"))
        return tempFile
    }


    @Test
    fun `given textAndStopFile when count then filtersElements`() {
        val stopFile = tempFileCreation(listOf("a"))
        val counter: WordCountInterface = WordCountService(stopFile)
        val result = counter.count("Mary had a little lamb")
        assertEquals(
            listOf(
                WordCount("mary", 1),
                WordCount("had", 1),
                WordCount("little", 1),
                WordCount("lamb", 1),
            ), result
        )
    }


    @Test
    fun `given sampleTextAndStopFile when count then returnsCorrectCounts`() {
        val stopFile = tempFileCreation(listOf("had", "a"))
        val counter: WordCountInterface = WordCountService(stopFile)
        val result = counter.count("Peter Pan had a brown hat")
        assertEquals(
            listOf(
                WordCount("peter", 1),
                WordCount("pan", 1),
                WordCount("brown", 1),
                WordCount("hat", 1),
            ), result
        )
    }

    @Test
    fun `given textAndEmptyStopFile when count then filtersNothing`() {
        val stopFile = tempFileCreation(emptyList())
        val counter: WordCountInterface = WordCountService(stopFile)
        val result = counter.count("Peter Pan had a brown hat")
        assertEquals(
            listOf(
                WordCount("peter", 1),
                WordCount("pan", 1),
                WordCount("had", 1),
                WordCount("a", 1),
                WordCount("brown", 1),
                WordCount("hat", 1),
            ), result
        )
    }

    @Test
    fun `given missingStopFile when serviceInit then throws Error`() {
        val nonexistentFile = File.createTempFile("testFail", ".txt")
        nonexistentFile.delete()
        assertThrows<Error> { WordCountService(nonexistentFile) }
    }


    @Test
    fun `given emptyStringInput when count then returns EmptyList`() {
        val stopFile = tempFileCreation(listOf("had", "a"))
        val counter: WordCountInterface = WordCountService(stopFile)
        val result = counter.count("")
        assertTrue(result.isEmpty())
    }
}