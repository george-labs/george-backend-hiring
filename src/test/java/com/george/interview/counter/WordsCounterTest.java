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

    var wordsCount = counter.countWords("Hello");
    Assertions.assertEquals(1, wordsCount);
  }

  @Test
  void countWordsFromMultipleWord() {

    var wordsCount = counter.countWords("Hello dear friend from space");
    Assertions.assertEquals(5, wordsCount);
  }

  @Test
  void countWordsInNullString() {

    var wordsCount = counter.countWords(null);
    Assertions.assertEquals(0, wordsCount);
  }

  @Test
  void countWordsInEmptyString() {

    var wordsCount = counter.countWords("");
    Assertions.assertEquals(0, wordsCount);
  }

  @Test
  void countWordsWithSpecificDelimitersString() {

    var wordsCount = counter.countWords("Hello4World\nHow\tAre-you");
    Assertions.assertEquals(5, wordsCount);
  }

  @Test
  void provideNullSetExpectIllegalArgumentException() {

    Assertions.assertThrows(IllegalArgumentException.class, () -> new WordsCounter(null));
  }
}
