import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StopWordLoaderTest {
    private val resourceName = "stopwords.txt"

    private val stopWordLoader = StopWordLoader(resourceName)

    @Test
    fun loadFromResourcesWillLoadSpecifiedFileFromResourcesAndReadsStopWordsLineByLine() {
        // given

        // then
        val stopWords = stopWordLoader.loadFromResources()

        // when
        val expected = setOf("the", "a", "on", "off")
        assertEquals(expected, stopWords)
    }

}