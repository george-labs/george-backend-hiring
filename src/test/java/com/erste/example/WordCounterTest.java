package com.erste.example;

import static java.util.Collections.emptySet;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.erste.example.dto.CountHolder;
import java.util.Set;
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
    assertEquals(9, countHolder.getUniqueWords());
  }

  @Test
  void shouldCountUniqueWordsWithStopWordsProvided() {
    WordCounter wordCounter = new WordCounter();

    CountHolder countHolder = wordCounter.getCounts("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall",
                                                    Set.of("a", "on"));
    assertEquals(7, countHolder.getUniqueWords());
  }
}