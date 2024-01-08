import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LineByLineFileWordParserTest {

    @Test
    fun testFileContainingWordsOnEachLineReturnsWordsAsList() {
        val lineByLineWordsParser = LineByLineFileWordParser()

        assertEquals(
            listOf("abc", "def", "ghi", "jkl"),
            lineByLineWordsParser.getWordsFromFile(javaClass.classLoader.getResource("test.txt")!!.file)
        )
    }
}