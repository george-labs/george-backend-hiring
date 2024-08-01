package com.george.interview.counter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordsCounterTest {

  private WordsCounter counter;

  @BeforeEach
  void setUp() {

    counter = new WordsCounter();
  }

  @Test
  void countWordsFromSingleWord() {

    var wordsCount = counter.countWords("Hello");
    Assertions.assertEquals(1, wordsCount);
  }
}
