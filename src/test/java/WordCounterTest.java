import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {

    private static final List<String> stopWords = List.of("a", "the", "on", "off");
    private WordCounter wordCounter = new WordCounter(stopWords);

    @Test
    public void testCountWords() {
        String test = "Mary had a lamb";
        long expectedCount = 3;
        assertEquals(expectedCount, wordCounter.countWords(test));
    }

    @Test
    public void testCountWordsWithNumericChars() {
        String test = "Mary had 3 lamb";
        long expectedCount = 3;
        assertEquals(expectedCount, wordCounter.countWords(test));
    }

    @Test
    public void testCountWordsWithNumericChars_2() {
        String test = "Mary had 3wr lamb";
        long expectedCount = 3;
        assertEquals(expectedCount, wordCounter.countWords(test));
    }

    @Test
    public void testCountWordsWithOnlyLowercase() {
        String test = "mary had 3 lamb";
        long expectedCount = 3;
        assertEquals(expectedCount, wordCounter.countWords(test));
    }

    @Test
    public void testCountWordsWithOnlyUppercase() {
        String test = "MARY HAD 3 LAMB";
        long expectedCount = 3;
        assertEquals(expectedCount, wordCounter.countWords(test));
    }

    @Test
    public void testCountWordsWithSpecialChars() {
        String test = "Mary had a ^lamb^";
        long expectedCount = 2;
        assertEquals(expectedCount, wordCounter.countWords(test));
    }

    @Test
    public void testCountWordsWithNull() {
        String test = null;
        long expectedCount = 0;
        assertEquals(expectedCount, wordCounter.countWords(test));
    }

    @Test
    public void testCountWordsWithEmpty() {
        String test = "";
        long expectedCount = 0;
        assertEquals(expectedCount, wordCounter.countWords(test));
    }
}