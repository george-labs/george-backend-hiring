import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.absolutePathString
import kotlin.io.path.deleteIfExists
import kotlin.io.path.writeText

class ApplicationTest {

    companion object {
        private lateinit var testStopWordsFile: Path

        @JvmStatic
        @BeforeAll
        fun setup() {
            testStopWordsFile = Files.createTempFile("testStopWords", "txt")
            testStopWordsFile.writeText("""
                the
                a
                on
                off
            """.trimIndent())
        }

        @JvmStatic
        @AfterAll
        fun cleanup() {
            testStopWordsFile.deleteIfExists()
        }
    }

    @Test
    fun countWordsInSentence() {
        // Given
        val outputStream = ByteArrayOutputStream(1024)

        val counter = Application(
            arguments = emptyArray(),
            stopWordsFile = testStopWordsFile.toFile(),
            textInputStream = "Mary had a little lamb".byteInputStream(),
            resultOutputStream = outputStream,
        )

        // When
        counter.run()

        // Then
        Assertions.assertEquals("Enter text: Number of words: 4\n", outputStream.toString())
    }

    @Test
    fun countWordsFromProvidedFile() {
        // Given
        val testInputFile = Files.createTempFile("testInputFile", "txt")
        testInputFile.writeText("""
            Mary had
            a little
            lamb
        """.trimIndent())

        val outputStream = ByteArrayOutputStream(1024)

        val counter = Application(
            arguments = arrayOf(testInputFile.absolutePathString()),
            stopWordsFile = testStopWordsFile.toFile(),
            textInputStream = "Mary had a little lamb".byteInputStream(),
            resultOutputStream = outputStream,
        )

        // When
        counter.run()

        // Then
        Assertions.assertEquals("Number of words: 4\n", outputStream.toString())
        testInputFile.deleteIfExists()
    }

}