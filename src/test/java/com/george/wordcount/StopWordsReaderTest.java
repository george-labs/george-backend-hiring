package com.george.wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class StopWordsReaderTest {

    @Test
    void testGetWordsOk() throws IOException {
        final String[] EXPECTED = new String[]{"the", "a", "on", "off"};
        final StopWordsReader stopWordsReader = new StopWordsReader("/stopwords.txt");

        final String[] result = stopWordsReader.getWords();

        Assertions.assertArrayEquals(EXPECTED, result);
    }

    @Test
    void testGetWordsFileNotFound() {
        Assertions.assertThrows(IOException.class, () -> new StopWordsReader("/notexisting.txt"));
    }

    @Test
    void testGetWordsWithEmptyFile() throws IOException {
        final String[] EXPECTED = new String[]{""};
        final StopWordsReader stopWordsReader = new StopWordsReader("/empty.txt");

        final String[] result = stopWordsReader.getWords();

        Assertions.assertArrayEquals(EXPECTED, result);
    }
}