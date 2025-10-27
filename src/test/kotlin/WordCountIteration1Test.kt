import interfaces.WordCountInterface
import model.WordCount
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import service.WordCountService
import kotlin.collections.listOf

class WordCountIteration1Test {

    val counter: WordCountInterface = WordCountService()

    @Test
    fun `empty word list`(){
        val emptySet = counter.count("")
        assertTrue(emptySet.isEmpty())

    }


    @Test
    fun `same word Different CameCase`(){
        val result = counter.count("dog Dog DOG")
        assertEquals(listOf(WordCount("dog",3)),result)

    }


}