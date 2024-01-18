import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.nio.file.Files
import kotlin.io.path.deleteIfExists
import kotlin.io.path.writeText

class ApplicationTest {

    @Test
    fun countWordsInSentence() {
        // Given
        val testStopWordsFile = Files.createTempFile("testStopWords", "txt")
        testStopWordsFile.writeText("""
            the
            a
            on
            off
        """.trimIndent())

        val outputStream = ByteArrayOutputStream(1024)

        val counter = Application(
            stopWordsFile = testStopWordsFile.toFile(),
            textInputStream = "Mary had a little lamb".byteInputStream(),
            resultOutputStream = outputStream,
        )

        // When
        counter.run()

        // Then
        Assertions.assertEquals("Enter text: Number of words: 4\n", outputStream.toString())
        testStopWordsFile.deleteIfExists()
    }

}