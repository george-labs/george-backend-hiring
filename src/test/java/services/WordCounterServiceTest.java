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
        var phrase = "Help me, Obi/Wan Kenobi.";
        var expectedCount = 3;

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

    @Test
    void testCountWords_withStopWordsFile_withPunctuation() {
        // Given
        wordCounterService = new WordCounterService("/stopwords.txt");
        var phrase = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        var expectedCount = 7;

        // When
        var actualCount = wordCounterService.countWords(phrase);

        // Then
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void testCountWords_withOutStopWordsFile_withPunctuation() {
        // Given
        wordCounterService = new WordCounterService("");
        var phrase = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        var expectedCount = 10;

        // When
        var actualCount = wordCounterService.countWords(phrase);

        // Then
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void countUniqueWords_withStopWordsFile_withPunctuation() {
        // Given
        wordCounterService = new WordCounterService("/stopwords.txt");
        var phrase = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        var expectedCount = 6;

        // When
        var actualCount = wordCounterService.countUniqueWords(phrase);

        // Then
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void countUniqueWords_withOutStopWordsFile_withPunctuation() {
        // Given
        wordCounterService = new WordCounterService("");
        var phrase = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        var expectedCount = 8;

        // When
        var actualCount = wordCounterService.countUniqueWords(phrase);

        // Then
        assertEquals(expectedCount, actualCount);
    }
}
