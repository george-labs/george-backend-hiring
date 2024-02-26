package com.george.wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordSplitterTest {

    @Test
    public void testWordCountOk() {
        final String input = "aa ass dd";
        final int expectedCount = 3;
        final String[] stopWords = {};

        final int words = WordSplitter.countWords(input, stopWords);

        Assertions.assertEquals(expectedCount, words);
    }

    @Test
    public void testWordCountWithNumbers() {
        final String input = "11 22 33";
        final int expectedCount = 0;
        final String[] stopWords = {};

        final int words = WordSplitter.countWords(input, stopWords);

        Assertions.assertEquals(expectedCount, words);
    }

    @Test
    public void testWordCountWithNull() {
        final String input = null;
        final int expectedCount = 0;
        final String[] stopWords = {};

        final int words = WordSplitter.countWords(input, stopWords);

        Assertions.assertEquals(expectedCount, words);
    }

    @Test
    public void testWordCountWithEmpty() {
        final String input = "";
        final int expectedCount = 0;
        final String[] stopWords = {};

        final int words = WordSplitter.countWords(input, stopWords);

        Assertions.assertEquals(expectedCount, words);
    }

}