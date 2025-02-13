import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MainFunctionIntegrationTest {

    @Test
    fun `test main with path parameter to file from example iteration 3`() {
        // Save the original System.out
        val originalOut = System.out

        // Prepare a stream to capture the output
        val outputStream = ByteArrayOutputStream()
        val printStream = PrintStream(outputStream)

        try {
            // Redirect System.out to our capturing printStream
            System.setOut(printStream)

            // Call the main function with a path param
            main(arrayOf("./tmp/testFileIteration3.txt"))

        } finally {
            // Restore original System.out
            System.setOut(originalOut)
        }

        // Convert output to string for assertions
        val output = outputStream.toString().trim()

        // Example assertion: check that the output contains expected text
        assertEquals(output, "Number of words: 4, unique: 4")
    }

    @Test
    fun `test main with path parameter to file from example iteration 4`() {
        // Save the original System.out
        val originalOut = System.out

        // Prepare a stream to capture the output
        val outputStream = ByteArrayOutputStream()
        val printStream = PrintStream(outputStream)

        try {
            // Redirect System.out to our capturing printStream
            System.setOut(printStream)

            // Call the main function with a path param
            main(arrayOf("./tmp/testFileIteration4.txt"))

        } finally {
            // Restore original System.out
            System.setOut(originalOut)
        }

        // Convert output to string for assertions
        val output = outputStream.toString().trim()

        // Example assertion: check that the output contains expected text
        assertEquals(output, "Number of words: 9, unique: 7")
    }

    @Test
    fun `test main with path parameter to file with 6 words`() {
        // Save the original System.out
        val originalOut = System.out

        // Prepare a stream to capture the output
        val outputStream = ByteArrayOutputStream()
        val printStream = PrintStream(outputStream)

        try {
            // Redirect System.out to our capturing printStream
            System.setOut(printStream)

            // Call the main function with a path param
            main(arrayOf("./tmp/testFileWith6Words.txt"))

        } finally {
            // Restore original System.out
            System.setOut(originalOut)
        }

        // Convert output to string for assertions
        val output = outputStream.toString().trim()

        // Example assertion: check that the output contains expected text
        assertEquals(output, "Number of words: 6, unique: 6")

    }

    @Test
    fun `test main with path parameter to file with 10 words`() {
        // Save the original System.out
        val originalOut = System.out

        // Prepare a stream to capture the output
        val outputStream = ByteArrayOutputStream()
        val printStream = PrintStream(outputStream)

        try {
            // Redirect System.out to our capturing printStream
            System.setOut(printStream)

            // Call the main function with a path param
            main(arrayOf("./tmp/testFileWith10Words.txt"))

        } finally {
            // Restore original System.out
            System.setOut(originalOut)
        }

        // Convert output to string for assertions
        val output = outputStream.toString().trim()

        assertEquals(output, "Number of words: 10, unique: 10")

    }

    @Test
    fun `test main with path parameter empty file will return 0`() {
        // Save the original System.out
        val originalOut = System.out
        val originalIn = System.`in`

        // Prepare a stream to capture the output
        val outputStream = ByteArrayOutputStream()
        val printStream = PrintStream(outputStream)
        // Simulate user typing "Hello from test" + Enter
        val inputStream = ByteArrayInputStream("dsad adas das d das ds".toByteArray())

        try {
            // 3) Redirect system IO to our test streams
            System.setOut(printStream)
            System.setIn(inputStream)

            // 4) Call your main function with an empty array -> no file argument
            main(arrayOf("./tmp/testFileEmpty.txt"))
        } finally {
            // 5) Restore original System IO
            System.setOut(originalOut)
            System.setIn(originalIn)
        }

        // Convert output to string for assertions
        val output = outputStream.toString().trim()

        assertEquals(output, "Number of words: 0, unique: 0")
    }

    @Test
    fun `test main with path parameter no file provided will fallback to the user input`() {
        // Save the original System.out
        val originalOut = System.out
        val originalIn = System.`in`

        // Prepare a stream to capture the output
        val outputStream = ByteArrayOutputStream()
        val printStream = PrintStream(outputStream)
        // Simulate user typing "Hello from test" + Enter
        val inputStream = ByteArrayInputStream("Hello World".toByteArray())

        try {
            // 3) Redirect system IO to our test streams
            System.setOut(printStream)
            System.setIn(inputStream)

            // 4) Call your main function with an empty array -> no file argument
            main(arrayOf())
        } finally {
            // 5) Restore original System IO
            System.setOut(originalOut)
            System.setIn(originalIn)
        }
        // Convert output to string for assertions and remove enter text prefix
        val output = outputStream.toString().trim().removePrefix("Enter text: \n")
        assertEquals(output, "Number of words: 2, unique: 2")
    }
}