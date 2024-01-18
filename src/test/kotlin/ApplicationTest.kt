import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.nio.file.Files
import kotlin.io.path.absolutePathString
import kotlin.io.path.deleteIfExists
import kotlin.io.path.writeText

class ApplicationTest {

    @Test
    fun countWordsInSentence() {
        // Given
        val outputStream = ByteArrayOutputStream(1024)

        val counter = Application(
            inputTextReader = InputTextReaderImpl(
                arguments = emptyArray(),
                textInputStream = "Mary had a little lamb".byteInputStream()
            ),
            stopWordsReader = ClasspathStopWordsReader(),
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
            inputTextReader = InputTextReaderImpl(
                arguments = arrayOf(testInputFile.absolutePathString()),
                textInputStream = "Mary had a little lamb".byteInputStream(),
            ),
            stopWordsReader = ClasspathStopWordsReader(),
            resultOutputStream = outputStream,
        )

        // When
        counter.run()

        // Then
        Assertions.assertEquals("Number of words: 4\n", outputStream.toString())
        testInputFile.deleteIfExists()
    }

}