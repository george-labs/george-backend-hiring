import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.nio.file.Files
import kotlin.io.path.absolutePathString
import kotlin.io.path.deleteIfExists
import kotlin.io.path.writeText

class ApplicationTest {

    @Test
    fun `count words in sentence`() {
        // Given
        val askForInputStream = ByteArrayOutputStream(1024)
        val resultStream = ByteArrayOutputStream(1024)

        askForInputStream.bufferedWriter().use { askForInputStreamWriter ->
            resultStream.bufferedWriter().use { resultStreamWriter ->
                val counter = Application(
                    inputTextReader = InputTextReaderImpl(
                        arguments = emptyArray(),
                        textInputStream = "Mary had a little lamb".byteInputStream(),
                        writer = askForInputStreamWriter,
                    ),
                    stopWordsReader = ClasspathStopWordsReader(),
                    resultWriter = StreamResultWriter(
                        writer = resultStreamWriter
                    ),
                )

                // When
                counter.run()
            }
        }

        // Then
        Assertions.assertEquals("Enter text: ", askForInputStream.toString())
        Assertions.assertEquals("Number of words: 4, unique: 4\n", resultStream.toString())
    }

    @Test
    fun `count words from provided file`() {
        // Given
        val askForInputStream = ByteArrayOutputStream(1024)
        val resultStream = ByteArrayOutputStream(1024)

        val testInputFile = Files.createTempFile("testInputFile", "txt")
        testInputFile.writeText(
            """
            Mary had
            a little
            lamb
        """.trimIndent()
        )

        askForInputStream.bufferedWriter().use { askForInputStreamWriter ->
            resultStream.bufferedWriter().use { resultStreamWriter ->
                val counter = Application(
                    inputTextReader = InputTextReaderImpl(
                        arguments = arrayOf(testInputFile.absolutePathString()),
                        textInputStream = "Mary had a little lamb".byteInputStream(),
                        writer = askForInputStreamWriter
                    ),
                    stopWordsReader = ClasspathStopWordsReader(),
                    resultWriter = StreamResultWriter(
                        writer = resultStreamWriter
                    ),
                )
                // When
                counter.run()
            }
        }

        // Then
        Assertions.assertEquals("", askForInputStream.toString())
        Assertions.assertEquals("Number of words: 4, unique: 4\n", resultStream.toString())
        testInputFile.deleteIfExists()
    }

}