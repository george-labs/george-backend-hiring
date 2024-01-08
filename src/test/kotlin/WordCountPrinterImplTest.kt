import fake.FakeFileWordParser
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WordCountPrinterImplTest {

    @Test
    fun testWordInputIsHandledFromCommandLineArguments() {
        val basicWordCounter = WordSplitterImpl()
        val wordsParser = FakeFileWordParser()
        val outputStream = ByteArrayOutputStream()

        val wordsCountPrinter = WordCountPrinterImpl(wordsParser, basicWordCounter, outputStream)

        wordsCountPrinter.printNumberOfWords(arrayOf("test.txt"), listOf("abc", "def"))

        assertFalse {
            outputStream.toString().contains("Enter text")
        }
    }

    @Test
    fun testWordInputIsHandledFromUserInput() {
        val basicWordCounter = WordSplitterImpl()
        val wordsParser = FakeFileWordParser()
        val outputStream = ByteArrayOutputStream()

        val wordsCountPrinter = WordCountPrinterImpl(wordsParser, basicWordCounter, outputStream)

        System.setIn("something something".byteInputStream())

        wordsCountPrinter.printNumberOfWords(arrayOf(), listOf("abc", "def"))

        assertTrue {
            outputStream.toString().contains("Enter text")
        }
    }
}
