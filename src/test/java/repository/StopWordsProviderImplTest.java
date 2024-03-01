package repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class StopWordsProviderImplTest {

    @Test
    void provideStopWordsTest() {
        StopWordsProvider stopWordsProvider = new StopWordsProviderImpl(new FileReader(), "teststopwords.txt");

        var stopWords = stopWordsProvider.provideStopWords();

        Assertions.assertTrue(stopWords.containsAll(List.of("the", "a", "on", "off")));
    }
}