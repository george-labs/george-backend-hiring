package logic;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordsCounterTest {

    public static final String INPUT_TEXT_LINE = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
    public static final List<String> EXPECTED_WORDS_LIST =
            List.of("Humpty-Dumpty", "sat", "wall", "Humpty-Dumpty", "had", "great", "fall");
    public static final List<String> STOP_WORDS = List.of("on", "a");

    @Test
    public void testGetWordList() {
        var extractedWords = new WordsCounter(INPUT_TEXT_LINE, STOP_WORDS).getWordList();
        assertEquals(EXPECTED_WORDS_LIST, extractedWords,
                "Words should be extracted and stop words should be excluded");
    }

    @Test
    void getNumberOfWords() {
        assertEquals(7, new WordsCounter(INPUT_TEXT_LINE, STOP_WORDS).getNumberOfWords(),
                "Number of unique words should be 9");
    }

    @Test
    void getNumberOfUniqueWords() {
        assertEquals(6,  new WordsCounter(INPUT_TEXT_LINE, STOP_WORDS).getNumberOfUniqueWords(),
                "Number of unique words should be 7");
    }
}
