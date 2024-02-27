import counter.WordCounter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountAlphaCharacterTest {
    private static WordCounter wordCounter;

    @BeforeAll
    public static void setUp() {
        wordCounter = new WordCounter();
    }

    @Test
    void testCountWords() {
        assertEquals(5, wordCounter.countWords("Mary had a little lamb"));
    }

    @Test
    void testBlankSpace() {
        assertEquals(2, wordCounter.countWords("         Word   word             "));
    }

    @Test
    void testNumericWordWithNonAlphaCharacter() {
        assertEquals(1, wordCounter.countWords("Word2   word             "));
    }

    @Test
    void testNumericWordBlank() {
        assertEquals(0, wordCounter.countWords(" "));
    }

    @Test
    void testNullString() {
        assertEquals(0, wordCounter.countWords(null));
    }

}
