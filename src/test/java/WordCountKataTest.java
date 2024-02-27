import counter.WordCounter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountKataTest {
    private static WordCounter wordCounter;

    @BeforeAll
    public static void setUp() throws IOException {
        wordCounter = new WordCounter();
        wordCounter.loadStopWords();
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
        assertEquals(6, wordCounter.getNumberOfUniqueWords());
    }


    @Test
    void testCountWords() {
        wordCounter.countWords("Mary had a little lamb");
        assertEquals(4, wordCounter.getNumberOfWords());
    }
    @Test
    void testBlankSpace() {
        wordCounter.countWords("         Word   word             ");
        assertEquals(2, wordCounter.getNumberOfWords());
    }


    @Test
    void testUniqueWords() {
        wordCounter.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");
        assertEquals(6, wordCounter.getNumberOfUniqueWords());
    }

    @Test
    void testUniqueWordsWithoutHypes() {
        wordCounter.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");
        assertEquals(6, wordCounter.getNumberOfUniqueWords());
    }


    @Test
    void testAvarageWordLenght() {
        wordCounter.countWords("hallo meine arbeit ist stressig");
        assertEquals(5.4, wordCounter.getAvarageWordLenght());
    }


    @Test
    void testPrintIndexes() {
        wordCounter.countWords("Mary had a little lamb");
        assertEquals("Index : \n" +
                "Mary\n" +
                "had\n" +
                "little\n" +
                "lamb", wordCounter.printIndex());
    }

}
