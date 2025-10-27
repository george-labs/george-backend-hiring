import interfaces.WordCountInterface
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import service.WordCountService
import java.io.File

class WordCountIteration5Test {
    private fun tempFileCreation(words: List<String>): File {
        val tempFile = File.createTempFile("stopwords", ".txt")
        tempFile.writeText(words.joinToString("\n"))
        return tempFile
    }


    @Test
    fun `given text input when collectWordCountElements, then and totalCount and uniqueCount then returns CorrectCounts of Total elements and Uniques with Hyphened`() {
        val stopFile = tempFileCreation(listOf("had", "a"))
        val counter: WordCountInterface = WordCountService(stopFile)
        val result = counter.collectWordCountElements("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.")

        val total = counter.totalCount(result)
        val uniques = counter.uniqueCount(result)

        assertEquals(7, total)
        assertEquals(6, uniques)
    }


    @Test
    fun `given text input when collectWordCountElements, then and totalCount and uniqueCount then collect total number  with only one Hyphened unique`() {
        val stopFile = tempFileCreation(listOf("had", "a","on"))
        val counter: WordCountInterface = WordCountService(stopFile)
        val result = counter.collectWordCountElements("Test-Test1 on a Test-Test1. Test-Test1 a Test-Test1.")

        val total = counter.totalCount(result)
        val uniques = counter.uniqueCount(result)

        assertEquals(4, total)
        assertEquals(1, uniques)
    }

    @Test
    fun `given text input when collectWordCountElements, then and totalCount and uniqueCount then collect total number  with only one unique`() {
        val stopFile = tempFileCreation(listOf("had", "a","on"))
        val counter: WordCountInterface = WordCountService(stopFile)
        val result = counter.collectWordCountElements("Test on a Test. Test had a Test.")

        val total = counter.totalCount(result)
        val uniques = counter.uniqueCount(result)

        assertEquals(4, total)
        assertEquals(1, uniques)
    }


}