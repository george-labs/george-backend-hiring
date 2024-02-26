package com.george.wordcount;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {

    @Test
    void testWordCounterWithEmptyArgs() throws IOException {
        final String[] args = {};
        final ByteArrayInputStream testIn = new ByteArrayInputStream("Mary had a lamb".getBytes());
        System.setIn(testIn);
        final WordCounter wordCounter = new WordCounter(args);

        String resultString = wordCounter.getResultString();

        assertEquals("Number of words: 3", resultString);
    }


    @Test
    void testWordCounterWithFileName() throws IOException {
        final String[] args = {"mytext.txt"};
        final WordCounter wordCounter = new WordCounter(args);

        String resultString = wordCounter.getResultString();

        assertEquals("Number of words: 4", resultString);
    }

    @Test
    void testWordCounterWithFileNameWithStopWords() throws IOException {
        final String[] args = {"stopwords.txt"};
        final WordCounter wordCounter = new WordCounter(args);

        String resultString = wordCounter.getResultString();

        assertEquals("Number of words: 0", resultString);
    }
}