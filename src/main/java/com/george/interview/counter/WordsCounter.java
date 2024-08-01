package com.george.interview.counter;

import java.util.Set;

public class WordsCounter {

  private final Set<String> ignoredWords;

  public WordsCounter(Set<String> ignoredWords) {

    if (ignoredWords == null) {
      throw new IllegalArgumentException("ignored words set cannot be null");
    }
    this.ignoredWords = ignoredWords;
  }

  public int countWords(String text) {

    if (text == null || text.isBlank()) {
      return 0;
    }
    var temporaryText = text;
    for (String word : ignoredWords) {
      temporaryText = temporaryText.replaceAll(word, "");
    }
    return temporaryText.split("\\P{Alpha}+").length;
  }
}
