package com.george.interview.counter;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordsCounterAcceptanceTest {

  private WordsCounter counter;

  @BeforeEach
  void setUp() {

    var excludedWords = createExcludedWords();
    counter = new WordsCounter(excludedWords);
  }

  @Test
  void ignoreAllWordsTest() {

    var result = counter.countWords("test hello");
    Assertions.assertEquals(0, result.wordCount());
  }

  private Set<String> createExcludedWords() {

    var result = new HashSet<String>();
    result.add("test");
    result.add("hello");
    return result;
  }
}