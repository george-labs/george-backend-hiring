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
        val result = wordCounter.countAllWords(sentence)

        // Then
        Assertions.assertEquals(5, result)
    }

    @Test
    fun `GIVEN and empty sentence WHEN wordCounter is called THEN return 0`() {
        // Given
        val sentence = ""
        val wordCounter = WordCounter()

        // When
        val result = wordCounter.countAllWords(sentence)

        // Then
        Assertions.assertEquals(0, result)
    }

    @Test
    fun `GIVEN an empty sentence with only whitespace, THEN return 0`() {
        //Given
        val sentence = "    "
        val wordCounter = WordCounter()

        //When
        val result = wordCounter.countAllWords(sentence)

        //Then
        Assertions.assertEquals(0, result)

    }

    @Test
    fun `GIVEN a sentence, WHEN a sentence contains a number, THEN do not count the number as a word`() {
        //Given
        val sentence = "Mary had 2 little lambs"
        val wordCounter = WordCounter()

        //When
        val result = wordCounter.countAllWords(sentence)

        //Then
        Assertions.assertEquals(4, result)
    }

    @Test
    fun `GIVEN a sentence, WHEN a word contains a number, THEN do not count the number as a word`() {
        //Given
        val sentence = "Mary2 had two little lambs"
        val wordCounter = WordCounter()

        //When
        val result = wordCounter.countAllWords(sentence)

        //Then
        Assertions.assertEquals(4, result)
    }

    @Test
    fun `GIVEN a sentence, AND a set of stopwords, THEN return the number of words in the sentence excluding the stopwords`() {
        //Given
        val sentence = "Mary had a little lamb"
        val stopWords = setOf("a", "had")
        val wordCounter = WordCounter()

        //When
        val result = wordCounter.countAllWords(sentence, stopWords)

        //Then
        Assertions.assertEquals(3, result)
    }

    @Test
    fun `GIVEN a sentence, AND a empty set of stopwords, THEN return the number of words in the sentence`() {
        //Given
        val sentence = "Mary had a little lamb"
        val stopWords = emptySet<String>()
        val wordCounter = WordCounter()

        //When
        val result = wordCounter.countAllWords(sentence, stopWords)

        //Then
        Assertions.assertEquals(5, result)
    }

    @Test
    fun `GIVEN a sentence, AND contains newline, THEN return the number of words in the sentence excluding the newline`() {
        //Given
        val sentence = "Mary\nhad a \nlittle lamb"
        val wordCounter = WordCounter()

        //When
        val result = wordCounter.countAllWords(sentence)

        //Then
        Assertions.assertEquals(5, result)
    }

    @Test
    fun `GIVEN a sentence, WHEN counting only unique words, THEN return the number of unique words in the sentence excluding the stopwords`() {
        //Given
        val sentence = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."
        val stopWords = setOf("the" , "a" , "on" ,"off")
        val wordCounter = WordCounter()

        //When
        val result = wordCounter.countUniqueWords(sentence, stopWords)

        //Then
        Assertions.assertEquals(7, result)
    }

    @Test
    fun `GIVEN a sentence, WHEN counting only unique words, THEN return the number of unique words in the sentence`() {
        //Given
        val sentence = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."
        val wordCounter = WordCounter()

        //When
        val result = wordCounter.countUniqueWords(sentence)

        //Then
        Assertions.assertEquals(9, result)
    }


}