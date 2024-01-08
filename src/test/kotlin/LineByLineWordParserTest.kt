import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LineByLineWordParserTest {

    @Test
    fun testFileContainingWordsOnEachLineReturnsWordsAsList() {
        val lineByLineWordsParser = LineByLineWordParser()

        assertEquals(
            listOf("abc", "def", "ghi", "jkl"),
            lineByLineWordsParser.getWordsFromFile(javaClass.classLoader.getResource("test.txt")!!.file)
        )
    }
}