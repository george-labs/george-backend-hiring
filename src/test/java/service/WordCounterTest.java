package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.CountWordResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import serivces.WordCounter;

class WordCounterTest {

  WordCounter wordCounter;

  @BeforeEach
  void setUp() {
    wordCounter = new WordCounter();
  }

  @Test
  void test_withoutSpaces_wordsOnly() {
    String input = "WoRd hi there hello";

    CountWordResponse result = wordCounter.countWords(input);

    assertEquals(4, result.getWordCount());
    assertEquals(4, result.getUniqueWordCount());
  }

  @Test
  void test_withSpaces_withInvalidWords() {
    String input = "  WoRd     hi the$re hello54   5468$ .?oa!  ";

    CountWordResponse result = wordCounter.countWords(input);

    assertEquals(3, result.getWordCount());
    assertEquals(3, result.getUniqueWordCount());
  }

  @Test
  void test_emptyInput() {
    String input = "";

    CountWordResponse result = wordCounter.countWords(input);

    assertEquals(0, result.getWordCount());
    assertEquals(0, result.getUniqueWordCount());
  }

  @Test
  void test_usingStopWords() {
    String input = "the a on off correct word";

    CountWordResponse result = wordCounter.countWords(input);

    assertEquals(2, result.getWordCount());
    assertEquals(2, result.getUniqueWordCount());
  }

  @Test
  void test_usingNotUniqueWords() {
    String input = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";

    CountWordResponse result = wordCounter.countWords(input);

    assertEquals(9, result.getWordCount());
    assertEquals(7, result.getUniqueWordCount());
  }
}
