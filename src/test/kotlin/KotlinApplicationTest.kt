import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.PrintStream


class KotlinApplicationTest {
    @Test
    fun `test word count`() {
        val numberOfWords = countWords("Hello world")

        Assertions.assertEquals(2,  numberOfWords)
    }

    @Test
    fun `test incorrect words are skipped`() {
        val numberOfWords = countWords("Hell0 wor1d")

        Assertions.assertEquals(0,  numberOfWords)
    }

    @Test
    fun `test that we skip also words with commas, semicolons, etc`() {
        val numberOfWords = countWords("Hello, world! We: should; skip| this.")

        Assertions.assertEquals(0,  numberOfWords)
    }

    @Test
    fun `test empty string`() {
        val numberOfWords = countWords("")

        Assertions.assertEquals(0,  numberOfWords)
    }

    @Test
    fun `test that words containing numbers or separators with space after at the end of the string are not counted`() {
        var numberOfWords = countWords("qwwq4 ")

        Assertions.assertEquals(0,  numberOfWords)

        numberOfWords = countWords("qwwqwerrw,  ")

        Assertions.assertEquals(0,  numberOfWords)
    }

    @Test
    fun `test stop words are taken into account`() {
        val stopWords = setOf("a", "the", "an")

        val numberOfWords = countWords("A quick brown fox jumps over the lazy dog", stopWords)

        Assertions.assertEquals(8,  numberOfWords)
    }

    @Test
    fun `test file does not exist`() {
        val dummyFileName = "nonexistentfile"

        val doesExist = checkStopWordsFileExists(dummyFileName)

        Assertions.assertFalse(doesExist)
    }

    @Test
    fun `test file exists`() {
        val dummyFileName = "somefile.txt"

        File(dummyFileName).createNewFile()
        val doesExist = checkStopWordsFileExists(dummyFileName)

        Assertions.assertTrue(doesExist)

        File(dummyFileName).delete()
    }

    @Test
    fun `test we correctly read stop words from file`() {
        // Sanity check
        Assertions.assertTrue(File(STOP_WORDS_FILE).exists())

        val stopWords = readStopWordsFromFile(STOP_WORDS_FILE)

        Assertions.assertEquals(setOf("a", "the", "on", "off"), stopWords)
    }

    @Test
    fun `test the main function`() {
        val inputStream = ByteArrayInputStream("A quick brown fox jumps over the lazy dog.".toByteArray())
        System.setIn(inputStream)
        val applicationOutput = ByteArrayOutputStream()
        System.setOut(PrintStream(applicationOutput))

        main(emptyArray())
        val output = applicationOutput.toString()

        Assertions.assertEquals("Enter text: Number of words: 7\r\n", output)

        System.setIn(System.`in`)
        System.setOut(System.out)
    }
}
