package com.george.wordcount;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterReaderTest {

    @Test
    void testWordCounterWithEmptyArgs() throws IOException {
        final String[] args = {};
        final ByteArrayInputStream testIn = new ByteArrayInputStream("Mary had a lamb".getBytes());
        System.setIn(testIn);
        final WordCounterReader wordCounterReader = new WordCounterReader(args);

        String resultString = wordCounterReader.getResultString();

        assertEquals("Number of words: 3, unique: 3; average word length: 3.67 characters", resultString);
    }


    @Test
    void testWordCounterWithFileName() throws IOException {
        final String[] args = {"mytext.txt"};
        final WordCounterReader wordCounterReader = new WordCounterReader(args);

        String resultString = wordCounterReader.getResultString();

        assertEquals("Number of words: 4, unique: 4; average word length: 4.25 characters", resultString);
    }

    @Test
    void testWordCounterWithFileNameWithStopWords() throws IOException {
        final String[] args = {"stopwords.txt"};
        final WordCounterReader wordCounterReader = new WordCounterReader(args);

        String resultString = wordCounterReader.getResultString();

        assertEquals("Number of words: 0, unique: 0; average word length: 0.00 characters", resultString);
    }
}