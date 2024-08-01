package com.george.interview.counter;

import java.util.Set;

public class WordsCounter {

  private Set<String> ignoredWords;

  public WordsCounter() {

  }

  public WordsCounter(Set<String> ignoredWords) {

    this.ignoredWords = ignoredWords;
  }

  public int countWords(String text) {

    if (text == null || text.isBlank()) {
      return 0;
    }
    return text.split("\\P{Alpha}+").length;
  }
}
