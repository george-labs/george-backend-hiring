package com.george.wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;

class ConsoleReaderTest {

    @Test
    public void testReadInput() throws IOException {
        final StringReader sr = new StringReader("test 123 aaa");
        final String expected = "Number of words: 2";
        final String[] stopWords = {};
        final ConsoleReader consoleReader = new ConsoleReader(stopWords);

        final String output = consoleReader.readInput(sr);

        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testReadInputNullReader() {
        final StringReader reader = null;
        final String[] stopWords = {};
        final ConsoleReader consoleReader = new ConsoleReader(stopWords);

        Assertions.assertThrows(IOException.class, () -> consoleReader.readInput(reader));
    }
}