package service;

import org.junit.jupiter.api.Test;

import java.io.Reader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordServiceTest {

    private final List<String> wordsNotToCount = List.of("the", "a", "on", "off");

    private final WordService wordService = new WordService();

    @Test
    public void testWordCount_shouldReturnPerfectMatch_whenStringContainsNoWordsNotToCount() {
        List<String> input = List.of("Mary", "had", "no", "lamb");
        assertEquals(4, wordService.countWords(input, wordsNotToCount));
    }

    @Test
    public void testWordCount_shouldReturnPerfectMatch_whenStringContainsOneWordNotToCount() {
        List<String> input = List.of("Mary", "had", "a", "lamb");
        assertEquals(3, wordService.countWords(input, wordsNotToCount));
    }

    @Test
    public void testWordCount_shouldReturnAlmostExactMatch_whenStringContainsNumber() {
        List<String> input = List.of("Mary", "h4d", "a", "lamb");
        assertEquals(2, wordService.countWords(input, wordsNotToCount));
    }

    @Test
    public void testWordCount_shouldReturnZero_whenStringIsEmpty() {
        assertEquals(0, wordService.countWords(List.of(), wordsNotToCount));
    }

    @Test
    public void testWordCount_shouldReturnZero_whenStringContainsAllWordsNotToCount() {
        List<String> input = List.of("the", "a", "on", "off");
        assertEquals(0, wordService.countWords(input, wordsNotToCount));
    }

    @Test
    public void testWordCount_shouldReturnZero_whenWordsNotToCountListIsEmpty() {
        List<String> input = List.of("the", "a", "on", "off");
        List<String> emptyWordsNotToCount = List.of();
        assertEquals(4, wordService.countWords(input, emptyWordsNotToCount));
    }
}
