import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.PrintStream

class MainEndToEndTest {
    val TEXT = """
        Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.
    """.trimIndent()

    val EXPECTED = "Number of words: 9, unique: 7"

    @Test
    fun testMainWithFileInput() {
        val tempFile = File.createTempFile("test", ".txt")
        tempFile.writeText(TEXT)
        val output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))

        main(arrayOf(tempFile.absolutePath))

        assertTrue(output.toString().contains(EXPECTED))
        tempFile.delete()
    }

    @Test
    fun testMainWithUserInput() {
        val input = ByteArrayInputStream(TEXT.toByteArray())
        val output = ByteArrayOutputStream()
        System.setIn(input)
        System.setOut(PrintStream(output))

        main(emptyArray())

        assertTrue(output.toString().contains(EXPECTED))
    }
}