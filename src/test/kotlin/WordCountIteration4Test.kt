import interfaces.WordCountInterface
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import service.WordCountService
import java.io.File

class WordCountIteration4Test {
    private fun tempFileCreation(words: List<String>): File {
        val tempFile = File.createTempFile("stopwords", ".txt")
        tempFile.writeText(words.joinToString("\n"))
        return tempFile
    }


    @Test
    fun `given text input when collectWordCountElements, then and collectTotalNrOfElements and collectUniqueNrOfElements then returns CorrectCounts of Total elements and Uniques`() {
        val stopFile = tempFileCreation(listOf("had", "a"))
        val counter: WordCountInterface = WordCountService(stopFile)
        val result = counter.collectWordCountElements("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.")

        val total = counter.collectTotalNrOfElements(result)
        val uniques = counter.collectUniqueNrOfElements(result)

        assertEquals(9, total)
        assertEquals(7, uniques)
    }


    @Test
    fun `given text input when collectWordCountElements, then and collectTotalNrOfElements and collectUniqueNrOfElements thencollect total number  with only one unique`() {
        val stopFile = tempFileCreation(listOf("had", "a","on"))
        val counter: WordCountInterface = WordCountService(stopFile)
        val result = counter.collectWordCountElements("Test on a Test. Test had a Test.")

        val total = counter.collectTotalNrOfElements(result)
        val uniques = counter.collectUniqueNrOfElements(result)

        assertEquals(4, total)
        assertEquals(1, uniques)
    }


}