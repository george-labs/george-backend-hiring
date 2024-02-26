package com.george.wordcount.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;

class FileReaderTest {
    @Test
    public void testReadInput() throws IOException {
        final StringReader sr = new StringReader("Mary had a little lamb");
        final String expected = "Number of words: 5";
        final String[] stopWords = {};
        final FileReader reader = new FileReader(stopWords);

        final String output = reader.readInput(sr);

        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testReadInputWithStopWords() throws IOException {
        final StringReader sr = new StringReader("Mary had a little lamb");
        final String expected = "Number of words: 4";
        final String[] stopWords = {"a"};
        final FileReader reader = new FileReader(stopWords);

        final String output = reader.readInput(sr);

        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testReadInputNullReader() {
        final StringReader nullReader = null;
        final String[] stopWords = {};
        final FileReader reader = new FileReader(stopWords);

        Assertions.assertThrows(IOException.class, () -> reader.readInput(nullReader));
    }

}