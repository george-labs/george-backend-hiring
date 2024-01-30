package application.infrastructure.config.file;

import application.infrastructure.config.StopWordsConfig;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StopWordsConfigFileTest {

    @Test
    void getStopWordsWhenResourceFileExists() {
        // given
        final String fileName = "stopwords.txt";
        final StopWordsConfig stopWordsConfig = new StopWordsConfigFile(fileName);

        // when
        final List<String> stopWords = stopWordsConfig.getStopWords();

        // then
        assertFalse(stopWords.isEmpty());
        assertEquals(4, stopWords.size());
    }

    @Test
    void getEmptyListForStopWordsWhenResourceFileDoesNotExists() {
        // given
        final String fileName = "bla.txt";
        final StopWordsConfig stopWordsConfig = new StopWordsConfigFile(fileName);

        // when
        final List<String> stopWords = stopWordsConfig.getStopWords();

        // then
        assertTrue(stopWords.isEmpty());
    }

    @Test
    void getEmptyListForStopWordsWhenNullIsGivenForResourceFile() {
        // given
        final String path = "bla.txt";
        final StopWordsConfig stopWordsConfig = new StopWordsConfigFile(null);

        // when
        final List<String> stopWords = stopWordsConfig.getStopWords();

        // then
        assertTrue(stopWords.isEmpty());
    }
}