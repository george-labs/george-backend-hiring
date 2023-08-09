import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

class WordCounterInputTest {

    private lateinit var wordsCounter: StubWordCounter
    private lateinit var wordCounterInput: WordCounterInput

    @BeforeEach
    fun setUp() {
        wordsCounter = StubWordCounter()
        wordCounterInput = WordCounterInput(wordsCounter)
    }

    @Test
    fun `process with program argument`() {
        val actual = wordCounterInput.process("./mytext.txt")
        assertEquals(WordCounterResult.ZERO, actual)
        val inputs = wordsCounter.inputs
        assertEquals(1, inputs.size)
        assertEquals("Mary had a little lamb", inputs.first())
    }

    @Test
    fun `process with command input`() {
        val tmpStream = ByteArrayInputStream("Mary had".toByteArray())
        System.setIn(tmpStream)
        val actual = wordCounterInput.process()
        assertEquals(WordCounterResult.ZERO, actual)
        val inputs = wordsCounter.inputs
        assertEquals(1, inputs.size)
        assertEquals("Mary had", inputs.first())
    }

    class StubWordCounter : WordCounter {

        val inputs = ArrayList<String>()

        override fun countWords(input: String): WordCounterResult {
            inputs.add(input)
            return WordCounterResult(0, 0)
        }
    }
}
