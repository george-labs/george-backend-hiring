package io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

class FileReaderTest {

    @Test
    void getStopWordsTest_wordsAreReturned() throws IOException {
        FileReader fileReader = new FileReader();
        final var actualResult = fileReader.getStopWords();

        Assertions.assertEquals(Arrays.asList("a", "aa"), actualResult);
    }

}