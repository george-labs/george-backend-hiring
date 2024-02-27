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
        wordCounter.countWords("a something you wanted the ");
        assertEquals(3, wordCounter.getNumberOfWords());
    }


    @Test
    void testNumericWordWithNonAlphaCharacter() {
        wordCounter.countWords("the   a             ");
        assertEquals(0, wordCounter.getNumberOfWords());
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
    void testNumberOfUniqueWords() {
        wordCounter.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");
        assertEquals(7, wordCounter.getNumberOfUniqueWords());
    }
}
