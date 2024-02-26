package com.george.wordcount;

import com.george.wordcount.reader.ConsoleReader;
import com.george.wordcount.reader.FileReader;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ContentReaderFactoryTest {

    @Test
    void testWordCounterWithEmptyArgs() throws IOException {
        final String[] args = {};
        final ContentReaderFactory contentReaderFactory = new ContentReaderFactory();
        System.setIn(new ByteArrayInputStream("aaa".getBytes()));

        ContentReader contentReader = contentReaderFactory.getContentReader(args);

        assertTrue(contentReader instanceof ConsoleReader);
    }


    @Test
    void testWordCounterWithFileName() throws IOException {
        final String[] args = {"mytext.txt"};
        final ContentReaderFactory contentReaderFactory = new ContentReaderFactory();

        ContentReader contentReader = contentReaderFactory.getContentReader(args);

        assertTrue(contentReader instanceof FileReader);
    }
}