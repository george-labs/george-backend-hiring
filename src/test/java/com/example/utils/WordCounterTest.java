package com.example.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCounterTest {
    @Test
    public void testCountCorrectWords() {
        String text = "Mary had a little lamb";
        int words = WordCounter.countWords(text);
        Assertions.assertEquals(5, words);
    }

    @Test
    public void testCountAlsoIncorrectAndSpecialCharactersWords() {
        String text = "M4ry had! a little lamb";
        int words = WordCounter.countWords(text);
        Assertions.assertEquals(3, words);
    }
}
