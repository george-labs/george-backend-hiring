package repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    @Test
    void provideStopWords() {
        FileReader fileReader = new FileReader("teststopwords.txt");

        var stopWords = fileReader.provideStopWords();

        Assertions.assertTrue(stopWords.containsAll(List.of("the", "a", "on", "off")));
    }
}