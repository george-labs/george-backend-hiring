package com.example.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WordCounterTest {
    @Test
    public void testCountCorrectWords() {
        String text = "Mary had a little lamb";
        int words = WordCounter.countWordsFilteringOutStopwords(text);
        Assertions.assertEquals(5, words);
    }

    @Test
    public void testCountAlsoIncorrectAndSpecialCharactersWords() {
        String text = "M4ry had! a little lamb";
        int words = WordCounter.countWordsFilteringOutStopwords(text);
        Assertions.assertEquals(3, words);
    }

    @Test
    public void testCountStopwordsBeingFilteredOut() {
        String text = "Mary had a little lamb";
        List<String> stopwords = List.of("the", "a", "on", "off");
        int words = WordCounter.countWordsFilteringOutStopwords(text, stopwords);
        Assertions.assertEquals(4, words);
    }
}
