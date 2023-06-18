package services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterServiceTest {
    private WordCounterService wordCounterService;

    @BeforeEach
    public void setup() {
        wordCounterService = new WordCounterService("/stopwords.txt");
    }

    @Test
    void testCountWords_phraseWithStopWords() {
        // Given
        var phrase = "May the Force be with you";
        var expectedCount = 5;

        // When
        long actualCount = wordCounterService.countWords(phrase);

        // Then
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void testCountWords_phraseWithoutStopWords() {
        // Given
        var phrase = "I find your lack of faith disturbing";
        var expectedCount = 7;

        // When
        long actualCount = wordCounterService.countWords(phrase);

        // Then
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void testCountWords_emptyPhrase() {
        // Given
        var emptyPhrase = "";
        var expectedCount = 0;

        // When
        var actualCount = wordCounterService.countWords(emptyPhrase);

        // Then
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void testCountWords_phraseWithSpecialCharacters() {
        // Given
        var phrase = "Help me, Obi-Wan Kenobi.";
        var expectedCount = 1;

        // When
        var actualCount = wordCounterService.countWords(phrase);

        // Then
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void testCountWords_withStopWordsFileNotFound_returnsTotalWordCount() {
        // Given
        wordCounterService = new WordCounterService("/nonexistent_stopwords.txt");
        var phrase = "May the Force be with you";
        var expectedCount = 6;

        // When
        var actualCount = wordCounterService.countWords(phrase);

        // Then
        assertEquals(expectedCount, actualCount);
    }
}
