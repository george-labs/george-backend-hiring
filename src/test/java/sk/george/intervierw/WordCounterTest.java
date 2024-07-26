package sk.george.intervierw;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sk.george.intervierw.word_counter.WordCounter;

class WordCounterTest {

    WordCounter wordCounter;
    String excludedWord;

    @BeforeEach
    void setUp() {
        excludedWord = "excludion";
        wordCounter = new WordCounter(Set.of(excludedWord));
    }

    @Test
    void count_returnsWordsCount_inputHasWords() {
        // Init data
        String input = "Mary had a little lamb";
        int expectedCount = 5;

        // Call the method
        long actualCount = wordCounter.count(input);

        // Assert the result
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void count_returns0_inputNullString() {
        // Init data
        int expectedCount = 0;

        // Call the method
        long actualCount = wordCounter.count(null);

        // Assert the result
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void count_returns0_inputBlankString() {
        // Init data
        String input = "   ";
        int expectedCount = 0;

        // Call the method
        long actualCount = wordCounter.count(input);

        // Assert the result
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void count_returnsWordsCount_inputWithNotAlphabeticWord() {
        // Init data
        String input = "Mary h4d a l#ttle lamb";
        int expectedCount = 3;

        // Call the method
        long actualCount = wordCounter.count(input);

        // Assert the result
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void count_returnsWordsCount_inputSentenceWithNumberIncluded() {
        // Init data
        String input = "Mary, I had a 1 little lamb!";
        int expectedCount = 6;

        // Call the method
        long actualCount = wordCounter.count(input);

        // Assert the result
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void count_returnsWordsCount_inputStringWithExcludedWord() {
        // Init data
        String input = "Mary had a 1 " + excludedWord + " little lamb!";
        int expectedCount = 5;

        // Call the method
        long actualCount = wordCounter.count(input);

        // Assert the result
        assertEquals(expectedCount, actualCount);
    }
}
