package service;

import dto.WordsNumbersDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordsCounterTest {

    @Test
    public void givenEmptyStringThenWordsCountShouldReturnZero() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "";

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text);

        assertEquals(0, numberOfWords.getNumberOfWords());
    }

    @Test
    public void givenNullThenWordsCountShouldReturnZero() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = null;

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text);

        assertEquals(0, numberOfWords.getNumberOfWords());
    }

    @Test
    public void givenNotEmptyStringWordsCountShouldReturnCorrectNumber() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Mary had a little lamb";

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text);

        assertEquals(5, numberOfWords.getNumberOfWords());
    }
    @Test
    public void givenStringSeparatedByMultipleSpacesWordsCountShouldReturnCorrectNumber() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Mary had a          little         lamb";

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text);

        assertEquals(5, numberOfWords.getNumberOfWords());
    }


    @Test
    public void givenStringSeparatedByMultipleSpacesAndNewLineWordsCountShouldReturnCorrectNumber() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Mary had a          little\n         lamb";

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text);

        assertEquals(5, numberOfWords.getNumberOfWords());
    }

    @Test
    public void givenStringWithNumberCharactersWordsCountShouldReturnZero() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "M4ry had a l1ttle lamb";

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text);

        assertEquals(3, numberOfWords.getNumberOfWords());
    }

    @Test
    public void givenStringWithSpecialCharactersWordsCountShouldReturnZero() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Mary' had a l1ttle lamb";

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text);

        assertEquals(3, numberOfWords.getNumberOfWords());
    }

    @Test
    public void givenEmptyStoppedWordsThenWordsCountShouldReturnCorrectNumber() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Here I am";
        List<String> stoppedWords = List.of();

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(3, numberOfWords.getNumberOfWords());
    }

    @Test
    public void givenNullStoppedListThenWordsCountShouldReturnCorrectNumber() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Here I am";
        List<String> stoppedWords = null;

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(3, numberOfWords.getNumberOfWords());
    }

    @Test
    public void givenNotEmptyStoppedWordsThenWordsCountShouldReturnCorrectNumber() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Here I am";
        List<String> stoppedWords = List.of("Here");

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(2, numberOfWords.getNumberOfWords());
    }

    @Test
    public void giveEveryWordsAreStoppedThenWordsCountShouldReturnZero() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Here I am";
        List<String> stoppedWords = List.of("Here", "I", "am");

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(0, numberOfWords.getNumberOfWords());
    }

    @Test
    public void giveNotStoppedWordNotPresentInTextThenWordsCountShouldReturnCorrectNumber() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Here I am";
        List<String> stoppedWords = List.of("Dog", "Cat", "Lion");

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(3, numberOfWords.getNumberOfWords());
    }

    @Test
    public void giveStoppedWordsContainIncorrectWordsInTextThenWordsCountShouldReturnCorrectNumber() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Mary' had a l1ttle lamb";
        List<String> stoppedWords = List.of("Dog", "1421412", "L%on");

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(3, numberOfWords.getNumberOfWords());
    }

    @Test
    public void giveStoppedWordsContainIncorrectWordsAndPresentWordsInTextThenWordsCountShouldReturnCorrectNumber() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Mary' had a l1ttle lamb";
        List<String> stoppedWords = List.of("had", "1421412", "L%on");

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(2, numberOfWords.getNumberOfWords());
    }

    @Test
    public void giveCaseInsensitiveStoppedWordPresentInTextThenWordsCountShouldReturnCorrectNumber() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Here I am";
        List<String> stoppedWords = List.of("HERE", "Cat", "Lion");

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(2, numberOfWords.getNumberOfWords());
    }

    @Test
    public void giveTextWithoutDuplicationThenWordsCountShouldReturnCorrectUniqueWords() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Here I am";
        List<String> stoppedWords = List.of();

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(3, numberOfWords.getUniqueNumberOfWords());
    }

    @Test
    public void giveTextWithDuplicationThenWordsCountShouldReturnCorrectUniqueWords() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Here I am Here";
        List<String> stoppedWords = List.of();

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(3, numberOfWords.getUniqueNumberOfWords());
    }

    @Test
    public void giveEmptyTextThenWordsCountShouldReturnZeroUniqueWords() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "";
        List<String> stoppedWords = List.of();

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(0, numberOfWords.getUniqueNumberOfWords());
    }

    @Test
    public void giveTextWithDuplicationAndStoppedWordsThenWordsCountShouldReturnCorrectUniqueWords() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Here I am Here";
        List<String> stoppedWords = List.of("Here");

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(2, numberOfWords.getUniqueNumberOfWords());
    }

    @Test
    public void giveTextWithouthDuplicationAndStoppedWordsThenWordsCountShouldReturnCorrectUniqueWords() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Here I am";
        List<String> stoppedWords = List.of("Here");

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(2, numberOfWords.getUniqueNumberOfWords());
    }

    @Test
    public void giveTextWithCaseSensitiveWordsThenWordsCountShouldReturnCorrectUniqueWords() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Here I am HERE";
        List<String> stoppedWords = List.of("");

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(4, numberOfWords.getUniqueNumberOfWords());
    }

    @Test
    public void giveTextWithHypeThenWordsCountShouldReturnCorrectUniqueWords() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Humpty-Dumpt I am HERE";
        List<String> stoppedWords = List.of("");

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(4, numberOfWords.getUniqueNumberOfWords());
    }

    @Test
    public void giveTextWithHypeThenWordsCountShouldReturnCorrectNumberOfWords() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Humpty-Dumpt I am HERE";
        List<String> stoppedWords = List.of("");

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(4, numberOfWords.getUniqueNumberOfWords());
    }

    @Test
    public void giveTextWithHypeAndOtherEndingCharacterWordsCountShouldReturnCorrectNumberWords() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        List<String> stoppedWords = List.of("");

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(10, numberOfWords.getNumberOfWords());
    }

    @Test
    public void giveTextWithHypeAndOtherEndingCharacterWordsCountShouldReturnCorrectUniqueWords() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        List<String> stoppedWords = List.of("");

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(8, numberOfWords.getUniqueNumberOfWords());
    }

    @Test
    public void giveTextWithOneWordCountShouldReturnCorrectAverageWords() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Here";
        List<String> stoppedWords = List.of("");

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(4.0000, numberOfWords.getAverageLength());
    }

    @Test
    public void giveTextWithSameLengthOfWordsCountShouldReturnCorrectAverageWords() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Here here here";
        List<String> stoppedWords = List.of("");

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(4.0000, numberOfWords.getAverageLength());
    }

    @Test
    public void giveTextWithDifferentLengthOfWordsCountShouldReturnCorrectAverageWords() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Here I am";
        List<String> stoppedWords = List.of("");

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(2.3333, numberOfWords.getAverageLength(), 0.0001);
    }

    @Test
    public void giveEmptyStringWordsCountShouldReturnCorrectAverageWords() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "";
        List<String> stoppedWords = List.of("");

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(0, numberOfWords.getAverageLength(), 0.0001);
    }

    @Test
    public void giveNullAsStringWordsCountShouldReturnCorrectAverageWords() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = null;
        List<String> stoppedWords = List.of("");

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(0, numberOfWords.getAverageLength(), 0.0001);
    }

    @Test
    public void giveTextWithOneWordCountAndStoppedWprdsShouldReturnCorrectAverageWords() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Here";
        List<String> stoppedWords = List.of("Here");

        WordsNumbersDto numberOfWords = wordsCounter.countWords(text, stoppedWords);

        assertEquals(0, numberOfWords.getAverageLength());
    }
}