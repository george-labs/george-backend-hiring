import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StopWordLoaderTest {

    private val stopWordLoader = StopWordLoader()

    @Test
    fun loadFromResourcesWillLoadSpecifiedFileFromResourcesAndReadsStopWordsLineByLine() {
        // given
        val resourceName = "stopwords.txt"

        // then
        val stopWords = stopWordLoader.loadFromResources(resourceName)

        // when
        val expected = setOf("the", "a", "on", "off")
        assertEquals(expected, stopWords)
    }

}