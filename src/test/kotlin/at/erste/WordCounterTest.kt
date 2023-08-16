package at.erste

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WordCounterTest {

    private val wordCounter = WordCounter(setOf("the", "a", "an", "and", "or", "but"))
    @Test
    fun testMultiplePunctuation() {
        val input = "Hello, world!!!"
        val expected = 2
        val actual = wordCounter.countWords(input)
        assertEquals(expected, actual)
    }

    @Test
    fun testSpecialCharacter() {
        val input = "Hello, my name is Stan9slav!!! How are you?"
        val expected = 7
        val actual = wordCounter.countWords(input)
        assertEquals(expected, actual)
    }

    @Test
    fun testSkippedWords() {
        val input = "Hello, my name is Stan9slav!!! But call me Stadna."
        val expected = 7
        val actual = wordCounter.countWords(input)
        assertEquals(expected, actual)
    }

    @Test
    fun testEmptyInput() {
        val input = ""
        val expected = 0
        val actual = wordCounter.countWords(input)
        assertEquals(expected, actual)
    }
}
