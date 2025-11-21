import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IOServiceTest {

    @Test
    fun getInputTextFromFile() {
        val service = IOService(System.`in`)

        val text = service.getInputText(arrayOf("src/test/resources/mytext.txt"))

        assertEquals("Mary had a little lamb", text)
    }

    @Test
    fun getInputTextFromInput() {
        val inputStream = IOService::class.java.getResourceAsStream("/mytext.txt")
            ?: throw IllegalStateException("test file not found")
        val service = IOService(inputStream)

        val text = service.getInputText(arrayOf())

        // Read just one line
        assertEquals("Mary had", text)
    }

    @Test
    fun getInputTextInclIndex() {
        val service = IOService(System.`in`)

        val text = service.getInputText(arrayOf("-index", "src/test/resources/mytext.txt"))

        assertEquals("Mary had a little lamb", text)
    }

    @Test
    fun showIndex() {
        val service = IOService(System.`in`)

        assertEquals(true, service.showIndex(arrayOf("-index", "src/test/resources/mytext.txt")))
        assertEquals(true, service.showIndex(arrayOf("src/test/resources/mytext.txt", "-index")))
        assertEquals(true, service.showIndex(arrayOf("-index")))
        assertEquals(false, service.showIndex(arrayOf("src/test/resources/mytext.txt")))
    }

    @Test
    fun dictionary() {
        val service = IOService(System.`in`)

        assertEquals(null, service.getDictionaryFileName(arrayOf("src/test/resources/mytext.txt")))
        assertEquals("", service.getDictionaryFileName(arrayOf("-dictionary=", "src/test/resources/mytext.txt")))
        assertEquals("mytestfile.txt", service.getDictionaryFileName(arrayOf("-dictionary=mytestfile.txt", "src/test/resources/mytext.txt")))
        assertEquals("mytestfile.txt", service.getDictionaryFileName(arrayOf("src/test/resources/mytext.txt", "-dictionary=mytestfile.txt")))
        assertEquals("mytestfile.txt", service.getDictionaryFileName(arrayOf("src/test/resources/mytext.txt", "-index", "-dictionary=mytestfile.txt")))
    }
}