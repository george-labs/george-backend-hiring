import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WordCounterTest {

    @Test
    fun countWordsInSentence() {
        // Given
        val counter = WordCounter()

        // When
        val result = counter.countWordsInText("Mary had a little lamb")

        // Then
        Assertions.assertEquals(5, result)
    }

    @Test
    fun countWordsWithSpecialCharacters() {
        // Given
        val counter = WordCounter()

        // When
        val result = counter.countWordsInText("  Ma23ry ha[]d ha\td ")

        // Then
        Assertions.assertEquals(6, result)
    }

    @Test
    fun countWordsWithJustWhitespace() {
        // Given
        val counter = WordCounter()

        // When
        val result = counter.countWordsInText(" ")

        // Then
        Assertions.assertEquals(0, result)
    }

    @Test
    fun countingSkipsIgnoredWords() {
        // Given
        val counter = WordCounter(
            stopWords = setOf("the", "a", "on", "off")
        )

        // When
        val result = counter.countWordsInText(" the a on off test ")

        // Then
        Assertions.assertEquals(1, result)
    }
}