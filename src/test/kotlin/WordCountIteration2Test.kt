import interfaces.WordCountInterface
import model.WordCount
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import service.WordCountService
import java.io.File

class WordCountIteration2Test {

    private fun tempFileCreation(words: List<String>): File {
        val tempFile = File.createTempFile("stopwords", ".txt")
        tempFile.writeText(words.joinToString("\n"))
        return tempFile
    }


    @Test
    fun `given textAndStopFileWithA when count then filtersA`() {
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
    fun `given textAndStopFileWithHadA when count then filtersHadAndA`() {
        val stopFile = tempFileCreation(listOf("had", "a"))
        val counter: WordCountInterface = WordCountService(stopFile)
        val result = counter.count("Mary had a little lamb")
        assertEquals(
            listOf(
                WordCount("mary", 1),
                WordCount("little", 1),
                WordCount("lamb", 1),
            ), result
        )
    }

    @Test
    fun `given textAndEmptyStopFile when count then filtersNothing`() {
        val stopFile = tempFileCreation(emptyList())
        val counter: WordCountInterface = WordCountService(stopFile)
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