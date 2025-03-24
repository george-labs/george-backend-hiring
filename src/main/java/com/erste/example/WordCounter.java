package com.erste.example;

import com.erste.example.dto.CountHolder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Class to count words
 */
public class WordCounter {

  /**
   * Returns counts of all words, unique words and average size of word.
   *
   * @param input     input to count words
   * @param stopWords words to filter out.
   * @return {@link CountHolder} with calculated counts
   */
  public CountHolder getCounts(String input, Set<String> stopWords) {
    Set<String> filteredWords = new HashSet<>();
    List<String> allWords = new ArrayList<>();
    List<Integer> wordLength = new ArrayList<>();
    getWordsStream(input, stopWords)
        .forEach(word -> {
          filteredWords.add(word);
          allWords.add(word);
          wordLength.add(word.length());
        });
    OptionalDouble average = wordLength.stream()
                                       .mapToInt(number -> number)
                                       .average();
    return new CountHolder(allWords.size(), filteredWords.size(), average.orElse(0.0));
  }

  /**
   * Returns stream of filtered and mapped words for further processing.
   *
   * @param input     input to count words
   * @param stopWords words to filter out.
   * @return stream of words
   */
  public Stream<String> getWordsStream(String input, Set<String> stopWords) {
    return Stream.of(input.split(" "))
                 .filter(word -> word.matches("[a-zA-Z-.]+"))
                 .filter(word -> !stopWords.contains(word))
                 .map(word -> word.replaceAll("\\.", ""));
  }
}
