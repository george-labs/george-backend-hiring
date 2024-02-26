package com.george.wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordSplitterTest {

    @Test
    public void testWordCountOk() {
        String input = "aa ass dd";
        int expectedCount = 3;

        int words = WordSplitter.countWords(input);

        Assertions.assertEquals(expectedCount, words);
    }

    @Test
    public void testWordCountWithNumbers() {
        String input = "11 22 33";
        int expectedCount = 0;

        int words = WordSplitter.countWords(input);

        Assertions.assertEquals(expectedCount, words);
    }

    @Test
    public void testWordCountWithNull() {
        String input = null;
        int expectedCount = 0;

        int words = WordSplitter.countWords(input);

        Assertions.assertEquals(expectedCount, words);
    }

    @Test
    public void testWordCountWithEmpty() {
        String input = "";
        int expectedCount = 0;

        int words = WordSplitter.countWords(input);

        Assertions.assertEquals(expectedCount, words);
    }

}