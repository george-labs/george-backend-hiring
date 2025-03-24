package com.erste.example;

import static java.util.Collections.emptySet;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import org.junit.jupiter.api.Test;

class WordCounterTest {

  @Test
  void shouldCountWords() {
    WordCounter wordCounter = new WordCounter();

    long count = wordCounter.countWords("Mary had a little lamb & cow", emptySet());

    assertEquals(6, count);
  }

  @Test
  void shouldCountWordsWitStopWordsProvided() {
    WordCounter wordCounter = new WordCounter();

    long count = wordCounter.countWords("Mary had a little lamb & cow", Set.of("a"));

    assertEquals(5, count);
  }

  @Test
  void shouldCountUniqueWords() {
    WordCounter wordCounter = new WordCounter();

    long count = wordCounter.countUniqueWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall",
                                              emptySet());
    assertEquals(9, count);
  }

  @Test
  void shouldCountUniqueWordsWithStopWordsProvided() {
    WordCounter wordCounter = new WordCounter();

    long count = wordCounter.countUniqueWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall",
                                              Set.of("a", "on"));
    assertEquals(7, count);
  }
}