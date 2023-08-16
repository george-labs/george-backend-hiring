package at.erste

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WordCounterTest {
    private val wordCounter = WordCounter(setOf("the ", "a", "an", "and", "or", "but"))

    @Test
    fun testSkippedWords() {
        val input = "dummy But dummy."
        val expected = 2
        val actual = wordCounter.countWords(input)
        assertEquals(expected, actual)
    }

    @Test
    fun testSkippedWordsWithSpace() {
        // the input list contains the "the " with the space included, so we need to check that is is also being excluded.
        val input = "The dummy the"
        val expected = 1
        val actual = wordCounter.countWords(input)
        assertEquals(expected, actual)
    }

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
    fun testEmptyInput() {
        val input = ""
        val expected = 0
        val actual = wordCounter.countWords(input)
        assertEquals(expected, actual)
    }
}
