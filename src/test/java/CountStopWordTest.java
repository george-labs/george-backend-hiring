import counter.WordCounter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountStopWordTest {
    private static WordCounter wordCounter;

    @BeforeAll
    public static void setUp() throws IOException {
        wordCounter = new WordCounter();
        wordCounter.loadStopWords();
    }

    @Test
    void testcountWordsExcludingStopWords() {
        assertEquals(3, wordCounter.countWordsExcludingStopWords("a something you wanted the "));
    }


    @Test
    void testNumericWordWithNonAlphaCharacter() {
        assertEquals(0, wordCounter.countWordsExcludingStopWords("the   a             "));
    }

    @Test
    void testNumericWordBlank() {
        assertEquals(0, wordCounter.countWordsExcludingStopWords(" "));
    }

    @Test
    void testNullString() {
        assertEquals(0, wordCounter.countWordsExcludingStopWords(null));
    }


}
