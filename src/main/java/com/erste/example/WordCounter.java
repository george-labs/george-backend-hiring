package com.erste.example;

import java.util.Set;
import java.util.stream.Stream;

/**
 * Class to count words
 */
public class WordCounter {

  /**
   * Count words in provided input, filter out words from provided stopWords.
   *
   * @param input     input to count words
   * @param stopWords words to filter out.
   * @return counted words
   */
  public long countWords(String input, Set<String> stopWords) {
    return Stream.of(input.split(" "))
                 .filter(word -> word.matches("[a-zA-Z]+"))
                 .filter(word -> !stopWords.contains(word))
                 .count();
  }
}
