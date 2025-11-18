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
        "'Mary had a little lamb'",
        "''",
        "'1 3 . @ #'",
    )
    fun mainLoopTest(input: String) {
        val inputCounter = AtomicInteger()
        val outputCounter = AtomicInteger()
        val reader = Reader {
            inputCounter.incrementAndGet()
            input
        }

        val writer = Writer {
            outputCounter.incrementAndGet()
        }

        tested.mainLoop(reader, writer)

        Assertions.assertEquals(1, inputCounter.get())
        Assertions.assertEquals(2, outputCounter.get())

    }

}