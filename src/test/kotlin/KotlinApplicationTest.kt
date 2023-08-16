import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinApplicationTest {

    @Test
    fun testCountWordsMultiplePunctuation() {
        val input = "Hello, world!!!"
        val expected = 2
        val actual = countWords(input)
        assertEquals(expected, actual)
    }

    @Test
    fun testCountWordsSpecialCharacter() {
        val input = "Hello, my name is Stan9slav!!! How are you?"
        val expected = 7
        val actual = countWords(input)
        assertEquals(expected, actual)
    }

    @Test
    fun testCountWordsEmptyInput() {
        val input = ""
        val expected = 0
        val actual = countWords(input)
        assertEquals(expected, actual)
    }
}
