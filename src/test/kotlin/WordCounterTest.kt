import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WordCounterTest {

    @Test
    fun `count words in sentence`() {
        // Given
        val counter = WordCounterImpl()

        // When
        val result = counter.countWordsInText("Mary had a little lamb")

        // Then
        Assertions.assertEquals(WordCounter.Result(
            wordCount = 5,
            uniqueWords = 5,
            averageWordLength = 3.6,
        ), result)
    }

    @Test
    fun `count words with special characters`() {
        // Given
        val counter = WordCounterImpl()

        // When
        val result = counter.countWordsInText("  Ma23ry ha[]d wor.d ")

        // Then
        Assertions.assertEquals(WordCounter.Result(
            wordCount = 0,
            uniqueWords = 0,
            averageWordLength = 0.0,
        ), result)
    }

    @Test
    fun `count words with just whitespace`() {
        // Given
        val counter = WordCounterImpl()

        // When
        val result = counter.countWordsInText(" ")

        // Then
        Assertions.assertEquals(WordCounter.Result(
            wordCount = 0,
            uniqueWords = 0,
            averageWordLength = 0.0,
        ), result)
    }

    @Test
    fun `counting skips ignored words`() {
        // Given
        val counter = WordCounterImpl(
            stopWords = setOf("the", "a", "on", "off")
        )

        // When
        val result = counter.countWordsInText(" the a on off test ")

        // Then
        Assertions.assertEquals(WordCounter.Result(
            wordCount = 1,
            uniqueWords = 1,
            averageWordLength = 4.0,
        ), result)
    }

    @Test
    fun `counts unique words only once`() {
        // Given
        val counter = WordCounterImpl()

        // When
        val result = counter.countWordsInText("foo foo bar foo bar")

        // Then
        Assertions.assertEquals(WordCounter.Result(
            wordCount = 5,
            uniqueWords = 2,
            averageWordLength = 3.0,
        ), result)
    }

    @Test
    fun `words with hyphen are counted`() {
        // Given
        val counter = WordCounterImpl()

        // When
        val result = counter.countWordsInText("foo-bar foo--bar fo-ob-ar")

        // Then
        Assertions.assertEquals(WordCounter.Result(
            wordCount = 3,
            uniqueWords = 3,
            averageWordLength = 7.666666666666667,
        ), result)
    }

    @Test
    fun wordsWithHyphenAtEdgeAreNotCounted() {
        // Given
        val counter = WordCounterImpl()

        // When
        val result = counter.countWordsInText("-foobar foobar-")

        // Then
        Assertions.assertEquals(WordCounter.Result(
            wordCount = 0,
            uniqueWords = 0,
            averageWordLength = 0.0,
        ), result)
    }

    @Test
    fun `complex sentence with hyphens is counted correctly`() {
        // Given
        val counter = WordCounterImpl(
            stopWords = setOf("the", "a", "on", "off")
        )

        // When
        val result = counter.countWordsInText("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.")

        // Then
        Assertions.assertEquals(WordCounter.Result(
            wordCount = 7,
            uniqueWords = 6,
            averageWordLength = 6.428571428571429,
        ), result)
    }

    @Test
    fun `builds index when flag is provided`() {
        // Given
        val counter = WordCounterImpl(
            stopWords = setOf("the", "a", "on", "off")
        )

        // When
        val result = counter.countWordsInText(
            text = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.",
            buildIndex = true
        )

        // Then
        Assertions.assertEquals(WordCounter.Result(
            wordCount = 7,
            uniqueWords = 6,
            averageWordLength = 6.428571428571429,
            index = listOf(
                "fall",
                "great",
                "had",
                "Humpty-Dumpty",
                "sat",
                "wall"
            )
        ), result)
    }
}