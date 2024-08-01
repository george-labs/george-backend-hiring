package com.george.interview.counter;

import com.george.interview.counter.model.CountResult;
import java.util.Set;

public class WordsCounter {

  private final Set<String> ignoredWords;

  public WordsCounter(Set<String> ignoredWords) {

    if (ignoredWords == null) {
      throw new IllegalArgumentException("ignored words set cannot be null");
    }
    this.ignoredWords = ignoredWords;
  }

  public CountResult countWords(String text) {

    if (text == null || text.isBlank()) {
      return new CountResult(0, 0);
    }
    var temporaryText = text;
    for (String word : ignoredWords) {
      temporaryText = temporaryText.replaceAll(word, "");
    }
    var splitText = temporaryText.split("[^a-zA-Z]+");
    return new CountResult(splitText.length, countUniqueWords(splitText));
  }

  int countUniqueWords(String[] splitText) {

    return 0;
  }
}
