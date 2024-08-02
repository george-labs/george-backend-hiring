package service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordsCounterTest {

    @Test
    public void givenEmptyStringThenWordsCountShouldReturnZero() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "";

        long numberOfWords = wordsCounter.countWords(text);

        assertEquals(0, numberOfWords);
    }

    @Test
    public void givenNullThenWordsCountShouldReturnZero() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = null;

        long numberOfWords = wordsCounter.countWords(text);

        assertEquals(0, numberOfWords);
    }

    @Test
    public void givenNotEmptyStringWordsCountShouldReturnCorrectNumber() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Mary had a little lamb";

        long numberOfWords = wordsCounter.countWords(text);

        assertEquals(5, numberOfWords);
    }
    @Test
    public void givenStringSeparatedByMultipleSpacesWordsCountShouldReturnCorrectNumber() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Mary had a          little         lamb";

        long numberOfWords = wordsCounter.countWords(text);

        assertEquals(5, numberOfWords);
    }


    @Test
    public void givenStringSeparatedByMultipleSpacesAndNewLineWordsCountShouldReturnCorrectNumber() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Mary had a          little\n         lamb";

        long numberOfWords = wordsCounter.countWords(text);

        assertEquals(5, numberOfWords);
    }

    @Test
    public void givenStringWithNumberCharactersWordsCountShouldReturnZero() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "M4ry had a l1ttle lamb";

        long numberOfWords = wordsCounter.countWords(text);

        assertEquals(3, numberOfWords);
    }

    @Test
    public void givenStringWithSpecialCharactersWordsCountShouldReturnZero() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Mary' had a l1ttle lamb";

        long numberOfWords = wordsCounter.countWords(text);

        assertEquals(3, numberOfWords);
    }
}