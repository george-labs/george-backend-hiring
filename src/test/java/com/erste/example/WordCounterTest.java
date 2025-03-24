package com.erste.example;

import static java.util.Collections.emptySet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.erste.example.dto.CountHolder;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class WordCounterTest {

  @Test
  void shouldCountWords() {
    WordCounter wordCounter = new WordCounter();

    CountHolder countHolder = wordCounter.getCounts("Mary had a little lamb & cow", emptySet());

    assertEquals(6, countHolder.getAllWords());
  }

  @Test
  void shouldCountWordsWitStopWordsProvided() {
    WordCounter wordCounter = new WordCounter();

    CountHolder countHolder = wordCounter.getCounts("Mary had a little lamb & cow", Set.of("a"));

    assertEquals(5, countHolder.getAllWords());
  }

  @Test
  void shouldCountUniqueWords() {
    WordCounter wordCounter = new WordCounter();

    CountHolder countHolder = wordCounter.getCounts("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall",
                                                    emptySet());
    assertEquals(8, countHolder.getUniqueWords());
  }

  @Test
  void shouldCountUniqueWordsWithStopWordsProvided() {
    WordCounter wordCounter = new WordCounter();

    CountHolder countHolder = wordCounter.getCounts("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall",
                                                    Set.of("a", "on"));
    assertEquals(6, countHolder.getUniqueWords());
  }

  @Test
  void shouldCalculateAverage() {
    WordCounter wordCounter = new WordCounter();

    CountHolder countHolder = wordCounter.getCounts("a df dfg dfgh sdfgh kjhbkjbkjbkj",
                                                    emptySet());
    assertEquals(4.5, countHolder.getAverageLenght());
  }

  @Test
  void shouldMapWordsToNotContainDot() {
    WordCounter wordCounter = new WordCounter();

    Stream<String> wordsStream = wordCounter.getWordsStream(
        "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall",
        emptySet());

    boolean noneMatch = wordsStream.collect(Collectors.toSet())
                                   .stream()
                                   .noneMatch(word -> word.contains("."));
    assertTrue(noneMatch);
  }
}