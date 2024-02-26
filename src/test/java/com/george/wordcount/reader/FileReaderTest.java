package com.george.wordcount.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;

class FileReaderTest {
    @Test
    public void testReadInput() throws IOException {
        final String expected = "Mary had a little lamb";
        final StringReader sr = new StringReader(expected);
        final FileReader reader = new FileReader(sr);

        final String output = reader.getContent();

        Assertions.assertEquals(expected + System.lineSeparator(), output);
    }

    @Test
    public void testReadInputNullReader() {
        final StringReader nullReader = null;

        Assertions.assertThrows(IOException.class, () -> new FileReader(nullReader).getContent());
    }

}