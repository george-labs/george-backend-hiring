package repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    @Test
    void provideStopWords() {
        StopWordsProvider stopWordsProvider = new StopWordsProvideImpl(new FileReader(), "teststopwords.txt");

        var stopWords = stopWordsProvider.provideStopWords();

        Assertions.assertTrue(stopWords.containsAll(List.of("the", "a", "on", "off")));
    }
}