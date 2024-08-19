package com.geogre.wordcount;

import static com.geogre.wordcount.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WordCounterTest {

    private final WordCounter wordCounter = new WordCounter(SEPARATOR, STOP_LIST);

    @Test
    void shouldCountWordsNormalString() {
        long result = wordCounter.count(TEST_INPUT);

        assertEquals(4, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void shouldCountWordsBlankString(String input) {
        long result = wordCounter.count(input);

        assertEquals(0, result);
    }

    @Test
    void shouldCountWordsStringWithDigits() {
        long result = wordCounter.count(TEST_INPUT_MIXED);

        assertEquals(2, result);
    }

    @Test
    void shouldCountWordsStringWithNoClearWords() {
        long result = wordCounter.count(TEST_INPUT_MIXED_NO_CLEAR_WORDS);

        assertEquals(0, result);
    }

    @Test
    void shouldCountWordsStringWithStopWords() {
        long result = wordCounter.count(TEST_INPUT_WITH_STOP_WORDS);

        assertEquals(3, result);
    }

}