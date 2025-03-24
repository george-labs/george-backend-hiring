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
    return getFilteredStream(input, stopWords)
        .count();
  }

  /**
   * Count unique words in provided input, filter out words from provided stopWords.
   *
   * @param input     input to count words
   * @param stopWords words to filter out.
   * @return counted words
   */
  public long countUniqueWords(String input, Set<String> stopWords) {
    return getFilteredStream(input, stopWords)
        .distinct()
        .count();
  }

  private Stream<String> getFilteredStream(String input, Set<String> stopWords) {
    return Stream.of(input.split(" |-"))
                 .filter(word -> word.matches("[a-zA-Z-.]+"))
                 .filter(word -> !stopWords.contains(word));
  }
}
