import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.PrintStream

class MainEndToEndTest {
    @Test
    fun testMainWithFileInput() {
        val tempFile = File.createTempFile("test", ".txt")
        tempFile.writeText("Mary had \na little \nlamb")
        val output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))

        main(arrayOf(tempFile.absolutePath))

        assertTrue(output.toString().contains("Word count: 4"))
        tempFile.delete()
    }

    @Test
    fun testMainWithUserInput() {
        val input = ByteArrayInputStream("Mary had a little lamb".toByteArray())
        val output = ByteArrayOutputStream()
        System.setIn(input)
        System.setOut(PrintStream(output))

        main(emptyArray())

        assertTrue(output.toString().contains("Word count: 4"))
    }
}