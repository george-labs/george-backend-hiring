import counter.WordCounter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountAlphaCharacterTest {
    private static WordCounter wordCounter;

    @BeforeAll
    public static void setUp() throws IOException {
        wordCounter = new WordCounter();
        wordCounter.loadStopWords();
    }

    @Test
    void testCountWords() {
        wordCounter.countWords("Mary had a little lamb");
        assertEquals(5, wordCounter.getNumberOfWords());
    }

    @Test
    void testBlankSpace() {
        wordCounter.countWords("         Word   word             ");
        assertEquals(2, wordCounter.getNumberOfWords());
    }

    @Test
    void testNumericWordWithNonAlphaCharacter() {
        wordCounter.countWords("Word2   word             ");
        assertEquals(1, wordCounter.getNumberOfWords());

    }

    @Test
    void testNumericWordBlank() {
        wordCounter.countWords(" ");
        assertEquals(0, wordCounter.getNumberOfWords());

    }

    @Test
    void testNullString() {
        wordCounter.countWords(null);
        assertEquals(0, wordCounter.getNumberOfWords());
    }


    @Test
    void testUniqueWords() {
        wordCounter.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");
        assertEquals(7, wordCounter.getNumberOfUniqueWords());
    }

}
