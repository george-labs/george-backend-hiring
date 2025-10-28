import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.FileNotFoundException

class FileReaderTest {
    private val fileReader = FileReader()

    @Test
    fun testReadFile() {
        val content = fileReader.readFile("src/main/resources/stopwords.txt")
        assert(content.isNotEmpty())
    }

    @Test
    fun testReadFileException() {
        assertThrows<FileNotFoundException> {
            fileReader.readFile("src/main/resources/stopwords123.txt")
        }
    }

    @Test
    fun testReadFileEmpty() {
        assertThrows<FileNotFoundException> {
            fileReader.readFile("")
        }
    }
}