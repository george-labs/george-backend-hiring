import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.FileNotFoundException

class KotlinApplicationTest {
    @Test
    fun testCountWords() {
        val noOfWords = countWords("Mary had a little lamb")
        assert(noOfWords == 4)
    }

    @Test
    fun testCountWordsEmpty() {
        val noOfWords = countWords("")
        assert(noOfWords == 0)
    }

    @Test
    fun testCountStopWords() {
        val stopWordsText = getStopWords().joinToString(" ")
        val noOfWords = countWords(stopWordsText)
        assert(noOfWords == 0)
    }

    @Test
    fun testReadFile() {
        val content = readFile("src/main/resources/stopwords.txt")
        assert(content.isNotEmpty())
    }

    @Test
    fun testReadFileException() {
        assertThrows<FileNotFoundException> {
            readFile("src/main/resources/stopwords123.txt")
        }
    }

    @Test
    fun testReadFileEmpty() {
        assertThrows<FileNotFoundException> {
            readFile("")
        }
    }
}