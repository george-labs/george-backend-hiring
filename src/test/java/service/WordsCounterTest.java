package service;

import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    public void givenEmptyStoppedWordsThenWordsCountShouldReturnCorrectNumber() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Here I am";
        List<String> stoppedWords = List.of();

        long numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(3, numberOfWords);
    }

    @Test
    public void givenNullStoppedListThenWordsCountShouldReturnCorrectNumber() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Here I am";
        List<String> stoppedWords = null;

        long numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(3, numberOfWords);
    }

    @Test
    public void givenNotEmptyStoppedWordsThenWordsCountShouldReturnCorrectNumber() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Here I am";
        List<String> stoppedWords = List.of("Here");

        long numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(2, numberOfWords);
    }

    @Test
    public void giveEveryWordsAreStoppedThenWordsCountShouldReturnZero() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Here I am";
        List<String> stoppedWords = List.of("Here", "I", "am");

        long numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(0, numberOfWords);
    }

    @Test
    public void giveNotStoppedWordNotPresentInTextThenWordsCountShouldReturnCorrectNumber() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Here I am";
        List<String> stoppedWords = List.of("Dog", "Cat", "Lion");

        long numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(3, numberOfWords);
    }

    @Test
    public void giveStoppedWordsContainIncorrectWordsInTextThenWordsCountShouldReturnCorrectNumber() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Mary' had a l1ttle lamb";
        List<String> stoppedWords = List.of("Dog", "1421412", "L%on");

        long numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(3, numberOfWords);
    }

    @Test
    public void giveStoppedWordsContainIncorrectWordsAndPresentWordsInTextThenWordsCountShouldReturnCorrectNumber() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Mary' had a l1ttle lamb";
        List<String> stoppedWords = List.of("had", "1421412", "L%on");

        long numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(2, numberOfWords);
    }

    @Test
    public void giveCaseInsensitiveStoppedWordPresentInTextThenWordsCountShouldReturnCorrectNumber() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Here I am";
        List<String> stoppedWords = List.of("HERE", "Cat", "Lion");

        long numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(2, numberOfWords);
    }
}