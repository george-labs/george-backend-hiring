import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {

    @Test
    void getNumberOfWordsTest_withoutStopWords() {
        WordCounter testCounter = new WordCounter();

        final var maryResult = testCounter.getNumberOfWords("Mary had a little lamb");
        final var quoteResult = testCounter.getNumberOfWords("To be free is to have achieved your life");

        assertEquals(5, maryResult);
        assertEquals(9, quoteResult);
    }

    @Test
    void getNumberOfWordsTest_withStopWords() {
        WordCounter testCounter = new WordCounter(List.of("a", "of","the"));

        final var maryResult = testCounter.getNumberOfWords("Mary had a little lamb");
        final var quoteResult = testCounter.getNumberOfWords("To be free is to have achieved your life");

        assertEquals(4, maryResult);
        assertEquals(9, quoteResult);
    }

    @Test
    public void getNumberOfWords_testWordsWithNumbers() {
        WordCounter wordCounter = new WordCounter();
        long wordCount = wordCounter.getNumberOfWords("Mary had a little lamb123 su41");
        assertEquals(4, wordCount);
    }

    @Test
    public void getNumberOfWords_testEmailAndSymbols() {
        WordCounter wordCounter = new WordCounter();
        long wordCount = wordCounter.getNumberOfWords("Mary had an email email@example.com");
        assertEquals(4, wordCount);
    }

    @Test
    public void getNumberOfWords_testMixedCaseWords() {
        WordCounter wordCounter = new WordCounter();
        long wordCount = wordCounter.getNumberOfWords("Mary HaD A Little LamB");
        assertEquals(5, wordCount);
    }

    @Test
    public void getNumberOfWords_testEmptyString() {
        WordCounter wordCounter = new WordCounter();
        long wordCount = wordCounter.getNumberOfWords("");
        assertEquals(0, wordCount);
    }

    @Test
    public void getNumberOfWords_testSpecialCharacters() {
        WordCounter wordCounter = new WordCounter();
        long wordCount = wordCounter.getNumberOfWords("12345 !@#$% ^&*() Mary had");
        assertEquals(2, wordCount);
    }
}
