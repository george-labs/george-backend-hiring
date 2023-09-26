package wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCounterTest {

    @Test
    public void testCountNumberOfWords() {
        String input = "Mary had a little lamb";

        int count = new WordCounter().countNumberOfWords(input);

        Assertions.assertEquals(5, count);
    }

    @Test
    public void testCountNumberOfWordsWithExtraNonLetterCharacters() {
        String input = "Mary had a little lamb !";

        int count = new WordCounter().countNumberOfWords(input);

        Assertions.assertEquals(5, count);
    }

    @Test
    public void testCountNumberOfWordsWithPunctuation() {
        String input = "Mary had a little lamb.";

        int count = new WordCounter().countNumberOfWords(input);

        Assertions.assertEquals(5, count);
    }

    @Test
    public void testCountNumberOfWordsWithDifferentCases() {
        String input = "MAry HAD a lIttle lamb.";

        int count = new WordCounter().countNumberOfWords(input);

        Assertions.assertEquals(5, count);
    }

    @Test
    public void testCountNumberOfWordsEmptyInput() {
        String input = "";

        int count = new WordCounter().countNumberOfWords(input);

        Assertions.assertEquals(0, count);
    }

    @Test
    public void testCountNumberOfWordsNullInput() {
        String input = null;

        int count = new WordCounter().countNumberOfWords(input);

        Assertions.assertEquals(0, count);
    }
}
