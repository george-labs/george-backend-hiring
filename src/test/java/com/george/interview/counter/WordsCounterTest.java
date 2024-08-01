package com.george.interview.counter;

import java.util.HashSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordsCounterTest {

  private WordsCounter counter;

  @BeforeEach
  void setUp() {

    counter = new WordsCounter(new HashSet<>());
  }

  @Test
  void countWordsFromSingleWord() {

    var result = counter.countWords("Hello");
    Assertions.assertEquals(1, result.wordCount());
  }

  @Test
  void countWordsFromMultipleWord() {

    var result = counter.countWords("Hello dear friend from space");
    Assertions.assertEquals(5, result.wordCount());
  }

  @Test
  void countWordsInNullString() {

    var result = counter.countWords(null);
    Assertions.assertEquals(0, result.wordCount());
  }

  @Test
  void countWordsInEmptyString() {

    var result = counter.countWords("");
    Assertions.assertEquals(0, result.wordCount());
  }

  @Test
  void countWordsWithSpecificDelimitersString() {

    var result = counter.countWords("Hello4World\nHow\tAre-you");
    Assertions.assertEquals(5, result.wordCount());
  }

  @Test
  void provideNullSetExpectIllegalArgumentException() {

    Assertions.assertThrows(IllegalArgumentException.class, () -> new WordsCounter(null));
  }
}
