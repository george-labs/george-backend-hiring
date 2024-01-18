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
        Assertions.assertEquals(WordCounter.Result(
            wordCount = 5,
            uniqueWords = 5
        ), result)
    }

    @Test
    fun countWordsWithSpecialCharacters() {
        // Given
        val counter = WordCounter()

        // When
        val result = counter.countWordsInText("  Ma23ry ha[]d word. ")

        // Then
        Assertions.assertEquals(WordCounter.Result(
            wordCount = 0,
            uniqueWords = 0
        ), result)
    }

    @Test
    fun countWordsWithJustWhitespace() {
        // Given
        val counter = WordCounter()

        // When
        val result = counter.countWordsInText(" ")

        // Then
        Assertions.assertEquals(WordCounter.Result(
            wordCount = 0,
            uniqueWords = 0
        ), result)
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
        Assertions.assertEquals(WordCounter.Result(
            wordCount = 1,
            uniqueWords = 1
        ), result)
    }

    @Test
    fun countsUniqueWordsOnlyOnce() {
        // Given
        val counter = WordCounter()

        // When
        val result = counter.countWordsInText("foo foo bar foo bar")

        // Then
        Assertions.assertEquals(WordCounter.Result(
            wordCount = 5,
            uniqueWords = 2
        ), result)
    }
}