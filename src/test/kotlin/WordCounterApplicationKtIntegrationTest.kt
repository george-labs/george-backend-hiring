import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class WordCounterApplicationKtIntegrationTest {

    @Test
    fun `should count words`() {
        System.setIn("Hello world I am David".byteInputStream())

        val output = ByteArrayOutputStream().use { bos ->
            PrintStream(bos).use { outputStream ->
                System.setOut(outputStream)
                val stopwordsFile = WordCounterApplicationKtIntegrationTest::class.java.getResource("stopwords.txt")!!.path

                main(arrayOf(stopwordsFile))

                outputStream.flush()

            }
            bos.toString()
        }
        assertEquals("Enter text: Number of words: 4\n", output)

    }
}
