import InputReader.InputScanner
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

class InputScannerTest {

    @Test
    fun getUserInputFromScannerHappyPath() {
        val input = "Mary had a little lamb"
        val inputStream = ByteArrayInputStream(input.toByteArray())
        val inputScanner = InputScanner(inputStream)
        val result = inputScanner.readText()

        Assertions.assertEquals(result, input)
    }
}