import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinApplicationTest {

    @Test
    fun testingFileArgs() {
        // Create a stream to capture output
        val outputStream = ByteArrayOutputStream()
        val originalOut = System.out

        // Redirect System.out to the new stream
        System.setOut(PrintStream(outputStream))

        main(arrayOf("/Users/eddie/Desktop/george-backend-hiring/src/main/resources/mytext.txt"))

        // Restore the original System.out
        System.setOut(originalOut)

        // Verify the output
        val capturedOutput = outputStream.toString().trim()

        assertEquals("Number of words: 4", capturedOutput)
    }

    /*
    @Test
    fun testingNoFileArgs() {
        // Create a stream to capture output
        val outputStream = ByteArrayOutputStream()
        val originalOut = System.out

        // Redirect System.out to the new stream
        System.setOut(PrintStream(outputStream))

        main(emptyArray<String>())

        // Restore the original System.out
        System.setOut(originalOut)

        // Verify the output
        val capturedOutput = outputStream.toString().trim()

        assertEquals("Number of words: 4", capturedOutput)
    }*/
}