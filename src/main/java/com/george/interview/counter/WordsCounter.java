package com.george.interview.counter;

public class WordsCounter {

  public int countWords(String text) {

    if (text == null || text.isBlank()) {
      return 0;
    }
    return text.split("\\P{Alpha}+").length;
  }
}
