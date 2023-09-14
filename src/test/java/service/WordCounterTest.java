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
    assertEquals(4, result.getUniqueWords().size());
  }

  @Test
  void test_withSpaces_withInvalidWords() {
    String input = "  WoRd     hi the$re hello54   5468$ .?oa!  ";

    CountWordResponse result = wordCounter.countWords(input);

    assertEquals(3, result.getWordCount());
    assertEquals(3, result.getUniqueWords().size());
  }

  @Test
  void test_emptyInput() {
    // when
    String input = "";

    // given
    CountWordResponse result = wordCounter.countWords(input);

    assertEquals(0, result.getWordCount());
    assertEquals(0, result.getUniqueWords().size());
  }

  @Test
  void test_usingStopWords() {
    // when
    String input = "the a on off correct word";

    // given
    CountWordResponse result = wordCounter.countWords(input);

    assertEquals(2, result.getWordCount());
    assertEquals(2, result.getUniqueWords().size());
  }

  @Test
  void test_usingNotUniqueWords() {
    // when
    String input = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";

    // given
    CountWordResponse result = wordCounter.countWords(input);

    assertEquals(7, result.getWordCount());
    assertEquals(6, result.getUniqueWords().size());
  }

  @Test
  void test_hypenAsAWord() {
    // when
    String input = "- valid invalid4";

    // given
    CountWordResponse result = wordCounter.countWords(input);

    assertEquals(1, result.getWordCount());
    assertEquals(1, result.getUniqueWords().size());
  }

  @Test
  void test_avgLenght_valid() {
    // given
    String input = "hi hu ha";

    // when
    CountWordResponse result = wordCounter.countWords(input);

    assertEquals(2.00, result.getAvgLength());
  }

  @Test
  void test_avgLenght_emptyInput() {
    // given
    String input = "";

    // when
    CountWordResponse result = wordCounter.countWords(input);

    assertEquals(0.00, result.getAvgLength());
  }

  // TODO: tests for index functionality
}
