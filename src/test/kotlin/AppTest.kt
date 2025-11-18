import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class AppTest {

    val tested = App()

    @ParameterizedTest
    @CsvSource(
        "'Mary had a little lamb', 5",
        "'Mary . had , a % little lamb', 5",
        "'Mary 3  had 4  a  little lamb', 5",
        "'M4ry 3  had 4  a  little lamb', 6",
        "'', 0",
        "'1 3 . @ ', 0",
    )
    fun mainLoop(input: String) {
        val reader = Reader {
            input
        }
        
        val writer = Writer {

        }
    }

}