import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class WordCountIT {

    @Test
    fun `count words by providing filename in args`() {
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
        try {
            // Call your main function
            main(arrayOf("src/test/resources/fileInputReader.txt"))

            // Convert to string
            val output = outputStream.toString().trim()

            assertEquals("Number of words: 3, unique: 3", output)

        } finally {
            // Restore original stdout
            System.setOut(System.out)
        }
    }

    @Test
    fun `count words by providing input through stdin`() {
        val input = "Mary had a little mary"
        val inputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        try {
            // Call your main function
            main(arrayOf())

            // Convert to string
            val output = outputStream.toString().trim()

            assertEquals("Enter text:Number of words: 2, unique: 2", output)

        } finally {
            // Restore original stdout
            System.setIn(System.`in`)
            System.setOut(System.out)
        }
    }
}

