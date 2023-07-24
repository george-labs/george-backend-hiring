package com.quiz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordCountTest {
    @Test
    void should_CountWords_When_InputJustLettersProvided() {
        String text = "Mary had a little lamb";
        IWordCount wordCount = new WordCount();
        Assertions.assertEquals(5, wordCount.count(text));
    }

    @Test
    void should_CountWords_When_InputLettersAndSpecialCharsProvided() {
        String text = "Mary had a l!ttle lamb";
        IWordCount wordCount = new WordCount();
        Assertions.assertEquals(4, wordCount.count(text));
    }

    @Test
    void should_CountWords_When_InputLettersAndNumbersProvided() {
        String text = "Mary had 1 little lamb";
        IWordCount wordCount = new WordCount();
        Assertions.assertEquals(4, wordCount.count(text));
    }

    @Test
    void should_CountWords_When_InputEmptyTextProvided() {
        String text = "";
        IWordCount wordCount = new WordCount();
        Assertions.assertEquals(0, wordCount.count(text));
    }

    @Test
    void should_CountWords_When_InputNullProvided() {
        IWordCount wordCount = new WordCount();
        Assertions.assertEquals(0, wordCount.count(null));
    }
}