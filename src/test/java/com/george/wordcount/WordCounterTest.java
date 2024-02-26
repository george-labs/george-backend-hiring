package com.george.wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordCounterTest {

    @Test
    public void testWordCountOk() {
        final String input = "aa ass dd";
        final int expectedCount = 3;
        final String[] stopWords = {};

        final WordCounter wordCounter = new WordCounter(input, stopWords);
        final int words = wordCounter.getCount();

        Assertions.assertEquals(expectedCount, words);
    }

    @Test
    public void testWordCountWithNumbers() {
        final String input = "11 22 33";
        final int expectedCount = 0;
        final String[] stopWords = {};

        final WordCounter wordCounter = new WordCounter(input, stopWords);
        final int words = wordCounter.getCount();

        Assertions.assertEquals(expectedCount, words);
    }

    @Test
    public void testWordCountWithHyphen() {
        final String input = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        final int expectedCount = 7;
        final String[] stopWords = {"the", "a", "on", "off"};

        final WordCounter wordCounter = new WordCounter(input, stopWords);
        final int words = wordCounter.getCount();

        Assertions.assertEquals(expectedCount, words);
    }

    @Test
    public void testWordCountWithUnique() {
        final String input = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        final int expectedCount = 7;
        final int expectedUniqueCount = 6;
        final String[] stopWords = {"the", "a", "on", "off"};

        final WordCounter wordCounter = new WordCounter(input, stopWords);

        Assertions.assertEquals(expectedCount, wordCounter.getCount());
        Assertions.assertEquals(expectedUniqueCount, wordCounter.getUniqueCount());
    }

    @Test
    public void testWordCountWithNull() {
        final String input = null;
        final int expectedCount = 0;
        final String[] stopWords = {};

        final WordCounter wordCounter = new WordCounter(input, stopWords);
        final int words = wordCounter.getCount();

        Assertions.assertEquals(expectedCount, words);
    }

    @Test
    public void testWordCountWithEmpty() {
        final String input = "";
        final int expectedCount = 0;
        final String[] stopWords = {};

        final WordCounter wordCounter = new WordCounter(input, stopWords);
        final int words = wordCounter.getCount();

        Assertions.assertEquals(expectedCount, words);
    }

}