package com.george.wordcount.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;

class ConsoleReaderTest {

    @Test
    public void testReadInput() throws IOException {
        final StringReader sr = new StringReader("Mary had a little lamb");
        final String expected = "Mary had a little lamb";
        final ConsoleReader reader = new ConsoleReader(sr);

        final String output = reader.getContent();

        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testReadInputNullReader() {
        final StringReader nullReader = null;

        Assertions.assertThrows(IOException.class, () -> new ConsoleReader(nullReader).getContent());
    }
}