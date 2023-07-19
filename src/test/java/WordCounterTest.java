import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordCounterTest {

    WordCounter wordCounter = new WordCounter();

    @Test
    public void testCountWords() {
        String testSentence = "This is test sentence";
        long result = wordCounter.countWords(testSentence);

        assertEquals(4, result);
    }

    @Test
    public void testCountWords_emptyString() {
        long result = wordCounter.countWords("");

        assertEquals(0, result);
    }

    @Test
    public void testCountWords_null() {
        long result = wordCounter.countWords(null);

        assertEquals(0, result);
    }

    @Test
    public void testCountWords_withNumbers() {
        String testSentence = "This is test sentence 2";
        long result = wordCounter.countWords(testSentence);

        assertEquals(4, result);
    }

    @Test
    public void testCountWords_withStopWords() {
        String testSentence = "This is the test sentence";
        long result = wordCounter.countWords(testSentence);

        assertEquals(4, result);
    }

    @Test
    public void testCountWords_withDots() {
        String testSentence = "This is test sentence. And another one.";
        long result = wordCounter.countWords(testSentence);

        assertEquals(7, result);
    }
}
