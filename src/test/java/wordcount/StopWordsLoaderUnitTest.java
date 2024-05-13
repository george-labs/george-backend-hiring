package wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StopWordsLoaderUnitTest {

    @Test
    void testLoadStopWordsHappyPath() {
        StopWordsLoader stopWordsLoader = new StopWordsLoader();

        Set<String> stopWords = stopWordsLoader.loadStopWords("src/main/resources/stopwords.txt");
        assertTrue(stopWords.containsAll(Set.of("the", "a", "on", "off")));
    }

    @Test
    void testLoadStopWordsEmptyFile() {
        StopWordsLoader stopWordsLoader = new StopWordsLoader();

        Set<String> stopWords = stopWordsLoader.loadStopWords("src/main/resources/stopwords_empty.txt");
        assertTrue(stopWords.isEmpty());
    }

    @Test
    void testLoadStopWordsNonExistentFile() {
        StopWordsLoader stopWordsLoader = new StopWordsLoader();

        Set<String> stopWords = stopWordsLoader.loadStopWords("src/main/resources/stopwords_nonexistent.txt");
        // TODO: catchException
        assertTrue(stopWords.isEmpty());
    }


}