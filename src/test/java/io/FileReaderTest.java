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

    @Test
    void readFileTest_resultReturned() throws IOException {
        FileReader fileReader = new FileReader();

        String actualResult = fileReader.readFile("src/test/resources/testfile.txt");

        Assertions.assertEquals("Mary had a little lamb", actualResult);
    }

    @Test
    void readFileTest_fileNotFoundExceptionThrown() {
        FileReader fileReader = new FileReader();

        Assertions.assertThrows(IOException.class,
                () -> fileReader.readFile("src/test/resources/nonexistent.txt"));

    }


}