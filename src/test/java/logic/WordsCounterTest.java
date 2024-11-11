package logic;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordsCounterTest {

    public static final String TEXT_LINE = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
    public static final List<String> EXTRACTED_WORDS_LIST =
            List.of("Humpty", "Dumpty", "sat", "wall", "Humpty", "Dumpty", "had", "great", "fall");
    public static final List<String> STOP_WORDS = List.of("on", "a");

    @Test
    public void testGetWordList() {
        var extractedWords = new WordsCounter(TEXT_LINE, STOP_WORDS).getWordList();
        assertEquals(EXTRACTED_WORDS_LIST, extractedWords,
                "Words should be extracted and stop words should be excluded");
    }

    @Test
    void getNumberOfUniqueWords() {
        assertEquals(7,  new WordsCounter(TEXT_LINE, STOP_WORDS).getNumberOfUniqueWords(),
                "Number of unique words should be 7");
    }

    @Test
    void getNumberOfWords() {
        assertEquals(9, new WordsCounter(TEXT_LINE, STOP_WORDS).getNumberOfWords(),
                "Number of unique words should be 9");
    }
}
