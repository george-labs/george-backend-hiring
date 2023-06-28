package services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterServiceTest {
    private WordCounterService wordCounterService;

    @BeforeEach
    public void setup() {
        wordCounterService = new WordCounterService();
    }

    @Test
    void testCountWords_phraseWithStopWords() {
        // Given
        var phrase = "May the Force be with you";
        var expectedCount = 5;
        var stopWordSet = new HashSet<>(List.of("the", "a", "on", "off"));

        // When
        long actualCount = wordCounterService.countWords(phrase, stopWordSet);

        // Then
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void testCountWords_phraseWithoutStopWords() {
        // Given
        var phrase = "I find your lack of faith disturbing";
        var expectedCount = 7;
        var stopWordSet = new HashSet<String>();

        // When
        long actualCount = wordCounterService.countWords(phrase, stopWordSet);

        // Then
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void testCountWords_emptyPhrase() {
        // Given
        var emptyPhrase = "";
        var expectedCount = 0;
        var stopWordSet = new HashSet<String>();

        // When
        var actualCount = wordCounterService.countWords(emptyPhrase, stopWordSet);

        // Then
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void testCountWords_phraseWithSpecialCharacters() {
        // Given
        var phrase = "Help me, Obi/Wan Kenobi.";
        var expectedCount = 3;
        var stopWordSet = new HashSet<String>();

        // When
        var actualCount = wordCounterService.countWords(phrase, stopWordSet);

        // Then
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void testCountWords_withStopWordsFileNotFound_returnsTotalWordCount() {
        // Given
        wordCounterService = new WordCounterService();
        var phrase = "May the Force be with you";
        var expectedCount = 6;
        var stopWordSet = new HashSet<String>();

        // When
        var actualCount = wordCounterService.countWords(phrase, stopWordSet);

        // Then
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void testCountWords_withStopWordsFile_withPunctuation() {
        // Given
        wordCounterService = new WordCounterService();
        var phrase = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        var expectedCount = 7;
        var stopWordSet = new HashSet<>(List.of("the", "a", "on", "off"));

        // When
        var actualCount = wordCounterService.countWords(phrase, stopWordSet);

        // Then
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void testCountWords_withOutStopWordsFile_withPunctuation() {
        // Given
        wordCounterService = new WordCounterService();
        var phrase = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        var expectedCount = 10;
        var stopWordSet = new HashSet<String>();


        // When
        var actualCount = wordCounterService.countWords(phrase, stopWordSet);

        // Then
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void testCountWords_withOutStopWordsFile_withPunctuation_withInvalidHyphenPlacement() {
        // Given
        wordCounterService = new WordCounterService();
        var phrase = "Humpty-Dumpty -sat on a wall. Humpty-Dumpty had- a great fall.";
        var expectedCount = 8;
        var stopWordSet = new HashSet<String>();

        // When
        var actualCount = wordCounterService.countWords(phrase, stopWordSet);

        // Then
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void countUniqueWords_withStopWordsFile_withPunctuation() {
        // Given
        wordCounterService = new WordCounterService();
        var phrase = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        var expectedCount = 6;
        var stopWordSet = new HashSet<>(List.of("the", "a", "on", "off"));

        // When
        var actualCount = wordCounterService.countUniqueWords(phrase, stopWordSet);

        // Then
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void countUniqueWords_withOutStopWordsFile_withPunctuation() {
        // Given
        wordCounterService = new WordCounterService();
        var phrase = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        var expectedCount = 8;
        var stopWordSet = new HashSet<String>();

        // When
        var actualCount = wordCounterService.countUniqueWords(phrase, stopWordSet);

        // Then
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void countUniqueWords_emptyPhrase() {
        // Given
        var emptyPhrase = "";
        var expectedCount = 0;
        var stopWordSet = new HashSet<>(List.of("the", "a", "on", "off"));

        // When
        var actualCount = wordCounterService.countUniqueWords(emptyPhrase, stopWordSet);

        // Then
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void countUniqueWords_withOutStopWordsFile_withPunctuation_withInvalidHyphenPlacement() {
        // Given
        wordCounterService = new WordCounterService();
        var phrase = "Humpty-Dumpty -sat on a wall. Humpty-Dumpty had- a great fall.";
        var expectedCount = 6;
        var stopWordSet = new HashSet<String>();

        // When
        var actualCount = wordCounterService.countUniqueWords(phrase, stopWordSet);

        // Then
        assertEquals(expectedCount, actualCount);
    }
}
