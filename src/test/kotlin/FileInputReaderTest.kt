import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FileInputReaderTest{
    private val fileInputReader = FileInputReader("./src/test/resources/fileInputReader.txt")

    @Test
    fun `fileInputReader reads text from given resource`(){
        assertNotNull(fileInputReader.read())
        assertTrue(fileInputReader.read().isNotEmpty())
    }
}