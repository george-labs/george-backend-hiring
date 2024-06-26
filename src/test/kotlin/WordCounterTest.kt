import domain.WordCounter
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WordCounterTest {


    @Test
    fun `GIVEN a sentence WHEN wordCounter is called THEN return the number of words in the sentence`() {
        // Given
        val sentence = "Mary had a little lamb"
        val wordCounter = WordCounter()

        // When
        val result = wordCounter.count(sentence)

        // Then
        Assertions.assertEquals(5, result)
    }

    @Test
    fun `GIVEN and empty sentence WHEN wordCounter is called THEN return 0`() {
        // Given
        val sentence = ""
        val wordCounter = WordCounter()

        // When
        val result = wordCounter.count(sentence)

        // Then
        Assertions.assertEquals(0, result)
    }

    @Test
    fun `GIVEN an empty sentence with only whitespace, THEN return 0`() {
        //Given
        val sentence = "    "
        val wordCounter = WordCounter()

        //When
        val result = wordCounter.count(sentence)

        //Then
        Assertions.assertEquals(0, result)

    }

    @Test
    fun `GIVEN a sentence, WHEN a sentence contains a number, THEN do not count the number as a word`() {
        //Given
        val sentence = "Mary had 2 little lambs"
        val wordCounter = WordCounter()

        //When
        val result = wordCounter.count(sentence)

        //Then
        Assertions.assertEquals(4, result)
    }

    @Test
    fun `GIVEN a sentence, WHEN a word contains a number, THEN do not count the number as a word`() {
        //Given
        val sentence = "Mary2 had two little lambs"
        val wordCounter = WordCounter()

        //When
        val result = wordCounter.count(sentence)

        //Then
        Assertions.assertEquals(4, result)
    }

}