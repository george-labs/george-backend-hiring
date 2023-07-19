import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WordCounterTest {

    WordCounter wordCounter = new WordCounter();

    @Test
    public void testFilterWords() {
        String testSentence = "This is test sentence";
        List<String> result = wordCounter.filterWords(testSentence);

        assertEquals(4, result.size());
    }

    @Test
    public void testCountWords_emptyString() {
        long result = wordCounter.countWords(new ArrayList<>());

        assertEquals(0, result);
    }

    @Test
    public void testCountWords_null() {
        long result = wordCounter.countWords(null);

        assertEquals(0, result);
    }

    @Test
    public void testFilterWords_withNumbers() {
        String testSentence = "This is test sentence 2";
        List<String> result = wordCounter.filterWords(testSentence);

        assertEquals(4, result.size());
    }

    @Test
    public void testFilterWords_withStopWords() {
        String testSentence = "This is the test sentence";
        List<String> result = wordCounter.filterWords(testSentence);

        assertEquals(4, result.size());
    }

    @Test
    public void testFilterWords_withDots() {
        String testSentence = "This is test sentence. And another one.";
        List<String> result = wordCounter.filterWords(testSentence);

        assertEquals(7, result.size());
    }

    @Test
    public void testCountUniqueWords() {
        String testSentence = "Mary had a little lamb. Had also other sentence.";

        List<String> words = wordCounter.filterWords(testSentence);
        assertNotNull(words);

        long result = wordCounter.countUniqueWords(words);

        assertEquals(7, result);
    }

    @Test
    public void testCountWords_separatedByDot() {
        String testSentence = "Humpty.Dumpty eats wall.";

        List<String> words = wordCounter.filterWords(testSentence);
        assertNotNull(words);

        long result = wordCounter.countWords(words);

        assertEquals(4, result);
    }

    @Test
    public void testCountWords_separatedByHyphen() {
        String testSentence = "Humpty-Dumpty eats wall.";

        List<String> words = wordCounter.filterWords(testSentence);
        assertNotNull(words);

        long result = wordCounter.countWords(words);

        assertEquals(3, result);
    }

    @Test
    public void testCountAvgLength() {
        String testSentence = "Humpty-Dumpty eats some wall.";

        List<String> words = wordCounter.filterWords(testSentence);
        assertNotNull(words);

        double result = wordCounter.countAvgLength(words);

        assertEquals(6.25, result);
    }
}
