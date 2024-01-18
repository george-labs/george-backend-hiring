import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WordCounterTest {

    @Test
    fun countWordsInSentence() {
        // Given
        val counter = WordCounter()

        // When
        val result = counter.countWordsInInput("Mary had a little lamb")

        // Then
        Assertions.assertEquals(5, result)
    }

    @Test
    fun countWordsWithSpecialCharacters() {
        // Given
        val counter = WordCounter()

        // When
        val result = counter.countWordsInInput("  Ma23ry ha[]d word. ")

        // Then
        Assertions.assertEquals(0, result)
    }

    @Test
    fun countWordsWithJustWhitespace() {
        // Given
        val counter = WordCounter()

        // When
        val result = counter.countWordsInInput(" ")

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
        val result = counter.countWordsInInput(" the a on off test ")

        // Then
        Assertions.assertEquals(1, result)
    }
}