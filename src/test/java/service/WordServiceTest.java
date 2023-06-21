package service;

import org.junit.jupiter.api.Test;
import service.WordService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordServiceTest {

    @Test
    public void testWordCount_shouldReturnPerfectMatch_whenStringIsValid() {
        String input = "Mary had a lamb";
        assertEquals(4, WordService.countWords(input));
    }

    @Test
    public void testWordCount_shouldReturnAlmostExactMatch_whenStringContainsNumber() {
        String input = "Mary h4d a lamb";
        assertEquals(3, WordService.countWords(input));
    }

    @Test
    public void testWordCount_shouldReturnZero_whenStringIsEmpty() {
        String input = "";
        assertEquals(0, WordService.countWords(input));
    }
}
