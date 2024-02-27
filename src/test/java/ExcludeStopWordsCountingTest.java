import counter.WordCounter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import util.FileReaderUtil;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExcludeStopWordsCountingTest {
    private static WordCounter wordCounter;
    private static FileReaderUtil fileReaderUtil;

    private static String text;

    @BeforeAll
    public static void setUp() throws IOException {
        wordCounter = new WordCounter();
        wordCounter.loadStopWords();
        fileReaderUtil = new FileReaderUtil("test.txt");
        text = new String(fileReaderUtil.readLineByLine());
    }

    @Test
    void testcountWordsExcludingStopWords() {
        assertEquals(3, wordCounter.countWords("a something you wanted the "));
    }


    @Test
    void testNumericWordWithNonAlphaCharacter() {
        assertEquals(0, wordCounter.countWords("the   a             "));
    }

    @Test
    void testNumericWordBlank() {
        assertEquals(0, wordCounter.countWords(" "));
    }

    @Test
    void testNullString() {
        assertEquals(0, wordCounter.countWords(null));
    }

    @Test
    void testCountWordsByLines() {
        assertEquals(3, wordCounter.countWords("a something you wanted the "));
    }
}
