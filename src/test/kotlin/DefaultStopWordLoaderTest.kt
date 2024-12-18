import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import stopWorldLoader.DefaultStopWordLoader

class DefaultStopWordLoaderTest {
    private val resourceName = "stopwords.txt"

    private val defaultStopWordLoader = DefaultStopWordLoader(resourceName)

    @Test
    fun loadFromResourcesWillLoadSpecifiedFileFromResourcesAndReadsStopWordsLineByLine() {
        // given

        // then
        val stopWords = defaultStopWordLoader.loadFromResources()

        // when
        val expected = setOf("the", "a", "on", "off")
        assertEquals(expected, stopWords)
    }

}