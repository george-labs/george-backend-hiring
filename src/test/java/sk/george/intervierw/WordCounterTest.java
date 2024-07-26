package sk.george.intervierw;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordCounterTest {

    WordCounter wordCounter;

    @BeforeEach
    void setUp() {
        wordCounter = new WordCounter();
    }

    @Test
    void count_returnsWords_inputHasWords() {
        // Init data
        String input = "Mary had a little lamb";
        int expectedCount = 5;

        // Call the method
        int actualCount = wordCounter.count(input);

        // Assert the result
        assertEquals(expectedCount, actualCount);
    }
}
