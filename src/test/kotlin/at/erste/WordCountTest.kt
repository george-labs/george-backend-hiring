package at.erste

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WordCountTest {

    @Test
    fun testMultiplePunctuation() {
        val input = "Hello, world!!!"
        val expected = 2
        val actual = countWords(input)
        assertEquals(expected, actual)
    }

    @Test
    fun testSpecialCharacter() {
        val input = "Hello, my name is Stan9slav!!! How are you?"
        val expected = 7
        val actual = countWords(input)
        assertEquals(expected, actual)
    }

    @Test
    fun testEmptyInput() {
        val input = ""
        val expected = 0
        val actual = countWords(input)
        assertEquals(expected, actual)
    }
}
