package com.george.wordcount.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;

class ConsoleReaderTest {

    @Test
    public void testReadInput() throws IOException {
        final StringReader sr = new StringReader("Mary had a little lamb");
        final String expected = "Number of words: 5, unique: 5; average word length: 3.60 characters";
        final String[] stopWords = {};
        final ConsoleReader reader = new ConsoleReader(stopWords);

        final String output = reader.readInput(sr);

        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testReadInputWithStopWords() throws IOException {
        final StringReader sr = new StringReader("Mary had a little lamb");
        final String expected = "Number of words: 4, unique: 4; average word length: 4.25 characters";
        final String[] stopWords = {"a"};
        final ConsoleReader reader = new ConsoleReader(stopWords);

        final String output = reader.readInput(sr);

        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testReadInputNullReader() {
        final StringReader nullReader = null;
        final String[] stopWords = {};
        final ConsoleReader reader = new ConsoleReader(stopWords);

        Assertions.assertThrows(IOException.class, () -> reader.readInput(nullReader));
    }
}