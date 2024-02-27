import counter.WordCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaApplicationTest {
    @Test
    void testCountWords() {
        WordCounter wordCounter = new WordCounter();
        assertEquals(5, wordCounter.countWords("Mary had a little lamb"));
    }
    @Test
    void testBlankSpace() {
        WordCounter wordCounter = new WordCounter();
        assertEquals(2, wordCounter.countWords("         Word   word             "));
    }
    @Test
    void testNumericWordWithNonAlphaCharacter() {
        WordCounter wordCounter = new WordCounter();
        assertEquals(1, wordCounter.countWords("Word2   word             "));
    }
    @Test
    void testNumericWordBlankr() {
        WordCounter wordCounter = new WordCounter();
        assertEquals(0, wordCounter.countWords(" "));
    }

}
