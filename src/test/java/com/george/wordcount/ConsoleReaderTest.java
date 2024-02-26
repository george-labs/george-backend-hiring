package com.george.wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;

class ConsoleReaderTest {

    @Test
    public void testReadInput() throws IOException {
        StringReader sr = new StringReader("test 123 aaa");
        String expected = "Number of words: 2";

        String output = ConsoleReader.readInput(sr);

        Assertions.assertEquals(expected, output);
    }
}