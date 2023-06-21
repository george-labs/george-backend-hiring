package service;

import org.junit.jupiter.api.Test;

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

    @Test
    public void testUniqueWordCount_shouldReturnUniqueWords_whenValidStringIsGiven() {
        List<String> input = List.of("Humpty", "Dumpty", "sat", "on", "a", "wall",
                "Humpty", "Dumpty", "had", "a", "great", "fall");
        assertEquals(7, wordService.countUniqueWords(input, wordsNotToCount));
    }

    @Test
    public void testUniqueWordCount_shouldReturnUniqueWords_whenSameWordsAreGiven() {
        List<String> input = List.of("Humpty", "Humpty", "Humpty", "Humpty", "Humpty", "Humpty", "Humpty", "Humpty");
        assertEquals(1, wordService.countUniqueWords(input, wordsNotToCount));
    }

    @Test
    public void testUniqueWordCount_shouldReturnZero_whenOnlyWordsNotToCountAreGiven() {
        List<String> input = List.of("the", "a", "on", "off");
        assertEquals(0, wordService.countUniqueWords(input, wordsNotToCount));
    }

    @Test
    public void testUniqueWordCount_shouldExactWordCountAndUniqueCount_whenSentenceContainsDashAndDot() {
        List<String> input = List.of("Humpty-Dumpty", "sat", "on", "a", "wall",
                "Humpty-Dumpty", "had", "a", "great", "fall");
        assertEquals(7, wordService.countWords(input, wordsNotToCount));
        assertEquals(6, wordService.countUniqueWords(input, wordsNotToCount));
    }

    @Test
    public void testCalculateAverageLength_shouldCalculateTheAverage_whenValidWordsAreGiven() {
        List<String> input = List.of("four", "four");
        assertEquals(4, wordService.calculateAverageLength(input));
    }
    @Test
    public void testCalculateAverageLength_shouldCalculateTheAverage_whenOneWordIsGiven() {
        List<String> input = List.of("four");
        assertEquals(4, wordService.calculateAverageLength(input));
    }

    @Test
    public void testCalculateAverageLength_shouldReturnZeroAsAverage_whenEmptyListIsUsed() {
        List<String> input = List.of();
        assertEquals(0.0, wordService.calculateAverageLength(input));
    }

    @Test
    public void testCalculateAverageLength_shouldReturnZeroAsAverage_whenEmptyWithEmptyStringIsUsed() {
        List<String> input = List.of("");
        assertEquals(0.0, wordService.calculateAverageLength(input));
    }
}
