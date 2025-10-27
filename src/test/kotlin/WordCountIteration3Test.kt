import interfaces.WordCountInterface
import model.WordCount
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import service.WordCountService
import java.io.File
import kotlin.collections.listOf

class WordCountIteration3Test {

    private fun tempFileCreation(words: List<String>): File {
        val tempFile = File.createTempFile("stopwords", ".txt")
        tempFile.writeText(words.joinToString("\n"))
        return tempFile
    }


    @Test
    fun `iteration3 we still filter out elements`() {
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
    fun `iteration3 test sample using the example ignoring words had and a`() {
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
    fun `empty StopFile Iteration 3`() {
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
    fun `case where the file presented input is empty Iteration 3`() {
        val stopFile = tempFileCreation(listOf("had", "a"))
        val counter: WordCountInterface = WordCountService(stopFile)
        val inexistingFile = File.createTempFile("testFail",  ".txt")

        val result = counter.count("")

        assertThrows<Error> {if(!inexistingFile.exists()) throw Error("File was not found:$result")  }
        assertTrue(result.isEmpty())
    }

}