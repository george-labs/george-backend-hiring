package integration;

import counter.WordCounter;
import exception.NullInputException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rule.ignore.WordsToIgnoreRule;
import separator.DelimiterSeparator;

class WordCounterIntegrationTest {

  private WordCounter wordCounter;

  @BeforeEach
  void beforeEach() {
    this.wordCounter = new WordCounter(new DelimiterSeparator(), new WordsToIgnoreRule(List.of()));
  }

  @Test
  void testHappyPathWordCount() {
    final String testString = "oleg is on a interview";
    long actualCount = this.wordCounter.countWords(testString);
    long expectedCount = 5;
    Assertions.assertEquals(expectedCount, actualCount);
  }

  @Test
  void testNonHappyPathWordCount() {
    final String testString = "oleg10, is on .a 9 / interview";
    long actualCount = this.wordCounter.countWords(testString);
    long expectedCount = 3;
    Assertions.assertEquals(expectedCount, actualCount);
  }

  @Test
  void testEmptyWordCount() {
    final String testString = "";
    long actualCount = this.wordCounter.countWords(testString);
    long expectedCount = 0;
    Assertions.assertEquals(expectedCount, actualCount);
  }

  @Test
  void testNullWordCount() {
    final String testString = null;
    Assertions.assertThrows(NullInputException.class, () -> this.wordCounter.countWords(testString));
  }
}
