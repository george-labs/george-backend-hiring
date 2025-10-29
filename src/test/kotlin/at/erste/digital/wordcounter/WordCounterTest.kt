package at.erste.digital.wordcounter

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WordCounterTest {
    @Test
    fun `should return 0 if input is empty`() {
        //GIVEN
        val input = ""
        //WHEN
        val numberOfWords = WordCounter.countWords(input)
        //THEN
        assertEquals(numberOfWords, 0)
    }

    @Test
    fun `should return 0 if input is blank`() {
        //GIVEN
        val input = "         "
        //WHEN
        val numberOfWords = WordCounter.countWords(input)
        //THEN
        assertEquals(numberOfWords, 0)
    }

    @Test
    fun `should return 1 if input is 1 word`() {
        //GIVEN
        val input = "test"
        //WHEN
        val numberOfWords = WordCounter.countWords(input)
        //THEN
        assertEquals(numberOfWords, 1)
    }

    @Test
    fun `should return 1 if input is 1 word with blanks`() {
        //GIVEN
        val input = "   test "
        //WHEN
        val numberOfWords = WordCounter.countWords(input)
        //THEN
        assertEquals(numberOfWords, 1)
    }


    @Test
    fun `should return 5 with input with 5 words and blanks`() {
        //GIVEN
        val input = "   test 123 ana wien atttt "
        //WHEN
        val numberOfWords = WordCounter.countWords(input)
        //THEN
        assertEquals(numberOfWords, 5)
    }

    @Test
    fun `should return number of words with new line separator`() {
        //GIVEN
        val input = """
            ana has a nice dog
            the dog is a border collie
        """.trimIndent()
        //WHEN
        val numberOfWords = WordCounter.countWords(input)
        //THEN
        assertEquals(numberOfWords, 11)
    }

}