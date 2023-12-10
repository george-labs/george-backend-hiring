import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordCountTest {
    private WordCount wordCount;

    @BeforeEach
    public void setUp() {
        wordCount = WordCount.getInstance();
    }

    @Test
    public void testWordCountSingleton() {
        WordCount anotherWordCount = WordCount.getInstance();
        assertSame(wordCount, anotherWordCount);
    }

    @Test
    public void testCountTextWithValidWords() {
        String testString = "Mary had a little lamb";
        int resultValue = wordCount.countText(testString);
        assertEquals(5, resultValue);
    }

    @Test
    public void testCountTextWithInvalidWords() {
        String testString = "M€ry h&d a li%%ttl3 lamb!";
        try {
            wordCount.countText(testString);
            fail("Did not throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Text containing non allowed characters", e.getMessage());
        }
    }

    @Test
    public void testCountTextWithEmptyText() {
        String testString = "";
        int resultValue = wordCount.countText(testString);
        assertEquals(0, resultValue);
    }
}
