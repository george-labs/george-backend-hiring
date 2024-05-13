package wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordCountUnitTest {
    @Test
    void testCountWordsHappyPath() {
        WordCount wordCount = new WordCount();
        Assertions.assertEquals(5, wordCount.countWords("Mary had a little lamb"));
    }

    @Test
    void testCountWordsEmptySentence() {
        WordCount wordCount = new WordCount();
        Assertions.assertEquals(0, wordCount.countWords(""));
    }

    @Test
    void testCountWordsNullSentence() {
        WordCount wordCount = new WordCount();
        Assertions.assertEquals(0, wordCount.countWords(null));
    }

    @Test
    void testCountWordsInvalidCharacters() {
        WordCount wordCount = new WordCount();
        Assertions.assertEquals(0, wordCount.countWords("1258 @!"));
    }

    @Test
    void testCountWordsSpecialCharacterDelimiter() {
        WordCount wordCount = new WordCount();
        Assertions.assertEquals(2, wordCount.countWords("abc!cbd"));
    }

    @Test
    void testCountWordsWithInvalidWords() {
        WordCount wordCount = new WordCount();
        Assertions.assertEquals(4, wordCount.countWords("Mary had a li25le 1258 @! lamb."));
    }
}
