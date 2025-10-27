import interfaces.WordCountInterface
import model.WordCount
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import service.WordCountService
import java.io.File
import kotlin.collections.listOf

class WordCountIteration2Test {

    private fun tempFileCreation(words: List<String>):File{
        val tempFile = File.createTempFile("stopwords",  ".txt")
        tempFile.writeText(words.joinToString ("\n"))
        return tempFile
    }


    @Test
    fun `iteration2 test sample using the example`(){
        val stopFile = tempFileCreation(listOf("a"))
        val counter: WordCountInterface = WordCountService(stopFile)
        val result = counter.count("Mary had a little lamb")
        assertEquals(listOf(
            WordCount("mary",1),
            WordCount("had",1),
            WordCount("little",1),
            WordCount("lamb",1),
        ),result)
    }


    @Test
    fun `iteration2 test sample using the example ignoring words had and a`(){
        val stopFile = tempFileCreation(listOf("had","a"))
        val counter: WordCountInterface = WordCountService(stopFile)
        val result = counter.count("Mary had a little lamb")
        assertEquals(listOf(
            WordCount("mary",1),
            WordCount("little",1),
            WordCount("lamb",1),
        ),result)
    }

    @Test
    fun `empty StopFile`(){
        val stopFile = tempFileCreation(emptyList())
        val counter: WordCountInterface = WordCountService(stopFile)
        val result = counter.count("Mary had a little lamb")
        assertEquals(listOf(
            WordCount("mary",1),
            WordCount("had",1),
            WordCount("a",1),
            WordCount("little",1),
            WordCount("lamb",1),
        ),result)
    }

}