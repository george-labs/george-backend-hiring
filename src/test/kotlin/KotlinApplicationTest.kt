import input.FileBasedReadInputStrategyTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import kotlin.text.toByteArray

class KotlinApplicationTest {

    private val expectedStopwords = listOf("the", "a", "on", "off")
    private val readerOutStream = ByteArrayOutputStream()
    private val writerOutStream = ByteArrayOutputStream()

    private val testFilePath =
        FileBasedReadInputStrategyTest::class.java.getResource("/test.txt")?.path ?: error("Resource not found")

    @Test
    fun `ensure that the stopwords are loaded in memory`() {
        assertEquals(expectedStopwords, stopwords)
    }

    @Test
    fun `test application end-to-end, file-based read strategy`() {
        executeBusinessLogic(arrayOf(testFilePath), readerOutStream, printerOutputStream = writerOutStream)

        assertEquals("Number of words: 4", String(writerOutStream.toByteArray()))
    }

    @Test
    fun `test application end-to-end, stdin input strategy`() {
        val inputStream = ByteArrayInputStream("Mary had a little lamb".toByteArray())
        executeBusinessLogic(emptyArray(), readerOutStream, inputStream, writerOutStream)

        assertEquals("Enter text: ", String(readerOutStream.toByteArray()))
        assertEquals("Number of words: 4", String(writerOutStream.toByteArray()))
    }
}