import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MainFunctionIntegrationTest {

    @Test
    fun `test main with path parameter to file from example`() {
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
        assertTrue(
            output.contains("Number of words: 4"),
            "Wrong output for the file with 4 words"
        )
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
        assertTrue(
            output.contains("Number of words: 6"),
            "Wrong output for the file with 6 words"
        )
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

        // Example assertion: check that the output contains expected text
        assertTrue(
            output.contains("Number of words: 10"),
            "Wrong output for the file with 10 words"
        )
    }

    @Test
    fun `test main with path parameter empty file will fallback to the user input`() {
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

        // Example assertion: check that the output contains expected text
        assertTrue(
            output.contains("Number of words: 6"),
            "Wrong output for the file with 6 words"
        )
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

        // Convert output to string for assertions
        val output = outputStream.toString().trim()

        // Example assertion: check that the output contains expected text
        assertTrue(
            output.contains("Number of words: 2"),
            "Wrong output for the file with 2 words"
        )
    }
}