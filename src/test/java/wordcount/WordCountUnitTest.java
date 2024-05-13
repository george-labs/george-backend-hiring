package wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

class WordCountUnitTest {

    StopWordsLoader stopWordsLoader = new StopWordsLoader();
    Set<String> stopWords = stopWordsLoader.loadStopWords("src/main/resources/stopwords_empty.txt");

    @Test
    void testCountWordsHappyPath() {
        WordCountService wordCountService = new WordCountService(stopWords);
        Assertions.assertEquals(5, wordCountService.countWords("Mary had a little lamb"));
    }

    @Test
    void testCountWordsEmptySentence() {
        WordCountService wordCountService = new WordCountService(stopWords);
        Assertions.assertEquals(0, wordCountService.countWords(""));
    }

    @Test
    void testCountWordsNullSentence() {
        WordCountService wordCountService = new WordCountService(stopWords);
        Assertions.assertEquals(0, wordCountService.countWords(null));
    }

    @Test
    void testCountWordsInvalidCharacters() {
        WordCountService wordCountService = new WordCountService(stopWords);
        Assertions.assertEquals(0, wordCountService.countWords("1258 @!"));
    }

    @Test
    void testCountWordsSpecialCharacterDelimiter() {
        WordCountService wordCountService = new WordCountService(stopWords);
        Assertions.assertEquals(2, wordCountService.countWords("abc!cbd"));
    }

    @Test
    void testCountWordsWithInvalidWords() {
        WordCountService wordCountService = new WordCountService(stopWords);
        Assertions.assertEquals(4, wordCountService.countWords("Mary had a li25le 1258 @! lamb."));
    }
}
