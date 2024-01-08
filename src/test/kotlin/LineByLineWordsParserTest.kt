import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LineByLineWordsParserTest {

    @Test
    fun testFileContainingWordsOnEachLineReturnsWordsAsList() {
        val lineByLineWordsParser = LineByLineWordsParser()

        assertEquals(
            listOf("abc", "def", "ghi", "jkl"),
            lineByLineWordsParser.getWordsFromFile(javaClass.classLoader.getResource("test.txt")!!.file)
        )
    }
}