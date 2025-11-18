import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.util.concurrent.atomic.AtomicInteger

class AppTest {
    val tested = App()

    @ParameterizedTest
    @CsvSource(
        "'Mary had a little lamb lamb', 'Number of words: 5, unique: 4; average word length: 4.25'",
        "'', 'Number of words: 0, unique: 0; average word length: 0'",
        "'the a on off NotATheOnOff', 'Number of words: 1, unique: 1; average word length: 12.00'",
        "'1 3 . @ #', 'Number of words: 0, unique: 0; average word length: 0'",
        "'Mary had\n a little\n lamb', 'Number of words: 4, unique: 4; average word length: 4.25'",
        "'Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.', 'Number of words: 7, unique: 6; average word length: 5.33'"
    )
    fun mainLoopTest(input: String, expectedOutput: String) {
        val inputCounter = AtomicInteger()
        val outputCounter = AtomicInteger()
        var lastOutput: String? = null

        val reader = Reader {
            inputCounter.incrementAndGet()
            input
        }

        val writer = Writer {
            outputCounter.incrementAndGet()
            lastOutput = it
        }

        tested.mainLoop(reader, writer)

        assertEquals(1, inputCounter.get())
        assertEquals(2, outputCounter.get())
        assertEquals(expectedOutput, lastOutput)

    }

}