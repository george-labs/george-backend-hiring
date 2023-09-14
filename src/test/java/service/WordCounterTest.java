package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    int result = wordCounter.countWords(input);

    assertEquals(4, result);
  }

  @Test
  void test_withSpaces_withInvalidWords() {
    String input = "  WoRd     hi the$re hello54   5468$ .?oa!  ";

    int result = wordCounter.countWords(input);

    assertEquals(2, result);
  }

  @Test
  void test_emptyInput() {
    String input = "";

    int result = wordCounter.countWords(input);

    assertEquals(0, result);
  }

  @Test
  void test_usingStopWords() {
    String input = "the a on off correct word";

    int result = wordCounter.countWords(input);

    assertEquals(2, result);
  }
}
