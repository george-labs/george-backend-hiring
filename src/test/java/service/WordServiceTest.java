package service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordServiceTest {

    private final List<String> wordsNotToCount = List.of("the", "a", "on", "off");

    @Test
    public void testWordCount_shouldReturnPerfectMatch_whenStringContainsNoWordsNotToCount() {
        String input = "Mary had no lamb";
        assertEquals(4, WordService.countWords(input, wordsNotToCount));
    }

    @Test
    public void testWordCount_shouldReturnPerfectMatch_whenStringContainsOneWordNotToCount() {
        String input = "Mary had a lamb";
        assertEquals(3, WordService.countWords(input, wordsNotToCount));
    }

    @Test
    public void testWordCount_shouldReturnAlmostExactMatch_whenStringContainsNumber() {
        String input = "Mary h4d a lamb";
        assertEquals(2, WordService.countWords(input, wordsNotToCount));
    }

    @Test
    public void testWordCount_shouldReturnZero_whenStringIsEmpty() {
        String input = "";
        assertEquals(0, WordService.countWords(input, wordsNotToCount));
    }

    @Test
    public void testWordCount_shouldReturnZero_whenStringContainsAllWordsNotToCount() {
        String input = "the a on off";
        assertEquals(0, WordService.countWords(input, wordsNotToCount));
    }

    @Test
    public void testWordCount_shouldReturnZero_whenWordsNotToCountListIsEmpty() {
        String input = "the a on off";
        List<String> emptyWordsNotToCount = List.of();
        assertEquals(4, WordService.countWords(input, emptyWordsNotToCount));
    }
}
