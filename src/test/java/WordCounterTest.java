import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCounterTest {

    WordCounter wordCounter = new WordCounter();

    @Test
    public void testCountWords() {
        String testSentence = "This is test sentence";
        long result = wordCounter.countWords(testSentence);

        Assertions.assertEquals(4, result);
    }

    @Test
    public void testCountWords_emptyString() {
        long result = wordCounter.countWords("");

        Assertions.assertEquals(0, result);
    }

    @Test
    public void testCountWords_null() {
        long result = wordCounter.countWords(null);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void testCountWords_withNumbers() {
        String testSentence = "This is test sentence 2";
        long result = wordCounter.countWords(testSentence);

        Assertions.assertEquals(4, result);
    }
}
