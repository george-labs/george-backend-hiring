import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinApplicationTest {

    @Test
    fun countWordsInSentence() {
        // Given

        // When
        val result = countWords("Mary had a little lamb")

        // Then
        Assertions.assertEquals(5, result)
    }

    @Test
    fun countWordsWithSpecialCharacters() {
        // Given

        // When
        val result = countWords("  Ma23ry ha[]d ha\td ")

        // Then
        Assertions.assertEquals(6, result)
    }

    @Test
    fun countWordsWithJustWhitespace() {
        // Given

        // When
        val result = countWords(" ")

        // Then
        Assertions.assertEquals(0, result)
    }
}