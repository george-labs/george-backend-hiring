import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.util.concurrent.atomic.AtomicInteger

class AppTest {

    val tested = App()

    @ParameterizedTest
    @CsvSource(
        "'Mary had a little lamb', 'Number of words: 4'",
        "'', 'Number of words: 0'",
        "'the a on off NotATheOnOff', 'Number of words: 1'",
        "'1 3 . @ #', 'Number of words: 0'",
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

        Assertions.assertEquals(1, inputCounter.get())
        Assertions.assertEquals(2, outputCounter.get())
        Assertions.assertEquals(expectedOutput, lastOutput)

    }

}