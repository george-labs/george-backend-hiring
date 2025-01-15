package unit.counter;

import counter.WordCounter;
import exception.NullInputException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rule.ignore.WordsToIgnoreRule;

class WordCounterTest {

  private WordCounter wordCounter;
  private MockedSeparator separator;

  @BeforeEach
  void beforeEach() {
    this.separator = new MockedSeparator();
    this.wordCounter = new WordCounter(this.separator, new WordsToIgnoreRule(List.of()));
  }

  @Test
  void testHappyPathWordCount() {
    final String testString = "oleg is on a interview";
    final List<String> separatedString = List.of("oleg", "is", "on", "a", "interview");
    this.separator.setMockedSeparatedStrings(separatedString);

    long actualCount = this.wordCounter.countWords(testString);
    long expectedCount = 5;
    Assertions.assertEquals(expectedCount, actualCount);
  }

  @Test
  void testNullWordCount() {
    final String testString = null;
    final List<String> separatedString = null;
    this.separator.setMockedSeparatedStrings(separatedString);
    Assertions.assertThrows(NullInputException.class, () -> this.wordCounter.countWords(testString));
  }

  @Test
  void testEmptyWordCount() {
    final String testString = "";
    final List<String> separatedString = List.of("");
    this.separator.setMockedSeparatedStrings(separatedString);

    long actualCount = this.wordCounter.countWords(testString);
    long expectedCount = 0;
    Assertions.assertEquals(expectedCount, actualCount);
  }

  @Test
  void testBlankWordCount() {
    final String testString = "    ";
    final List<String> separatedString = List.of(testString);
    this.separator.setMockedSeparatedStrings(separatedString);

    long actualCount = this.wordCounter.countWords(testString);
    long expectedCount = 0;
    Assertions.assertEquals(expectedCount, actualCount);
  }

  @Test
  void testIncorrectSeparationWordCount() {
    final String testString = "OLEG";
    final List<String> separatedString = new ArrayList<>();
    separatedString.add("OLEG");
    separatedString.add(null);
    this.separator.setMockedSeparatedStrings(separatedString);

    long actualCount = this.wordCounter.countWords(testString);
    long expectedCount = 1;
    Assertions.assertEquals(expectedCount, actualCount);
  }

  @Test
  void testWordFusedWithDelimitersCount() {
    final String testString = "oleg, is on a .interview";
    final List<String> separatedString = List.of("oleg,", "is", "on", "a", ".interview");
    this.separator.setMockedSeparatedStrings(separatedString);

    long actualCount = this.wordCounter.countWords(testString);
    long expectedCount = 3;
    Assertions.assertEquals(expectedCount, actualCount);
  }

  @Test
  void testWordsAndDelimitersSeparatedBySpaseCount() {
    final String testString = "oleg , is on a . interview";
    final List<String> separatedString = List.of("oleg", ",", "is", "on", "a", ".", "interview");
    this.separator.setMockedSeparatedStrings(separatedString);

    long actualCount = this.wordCounter.countWords(testString);
    long expectedCount = 5;
    Assertions.assertEquals(expectedCount, actualCount);
  }

  @Test
  void testWordsAndDigitsSeparatedBySpaseCount() {
    final String testString = "oleg 10 is on a 5 interview";
    final List<String> separatedString = List.of("oleg", "10", "is", "on", "a", "5", "interview");
    this.separator.setMockedSeparatedStrings(separatedString);

    long actualCount = this.wordCounter.countWords(testString);
    long expectedCount = 5;
    Assertions.assertEquals(expectedCount, actualCount);
  }

  @Test
  void testWordsFusiedWithDigitsCount() {
    final String testString = "oleg10 is on a 5interview";
    final List<String> separatedString = List.of("oleg10", "is", "on", "a", "5interview");
    this.separator.setMockedSeparatedStrings(separatedString);

    long actualCount = this.wordCounter.countWords(testString);
    long expectedCount = 3;
    Assertions.assertEquals(expectedCount, actualCount);
  }

  @Test
  void testWithWordsToIgnore() {
    final String testString = "oleg is on a interview";
    final List<String> separatedString = List.of("oleg", "is", "on", "a", "interview");
    this.separator.setMockedSeparatedStrings(separatedString);

    final List<String> wordsToIgnoreImmutableValues = List.of("oleg", "interview");
    this.wordCounter = new WordCounter(this.separator, new WordsToIgnoreRule(wordsToIgnoreImmutableValues));

    long actualCount = this.wordCounter.countWords(testString);
    long expectedCount = 3;
    Assertions.assertEquals(expectedCount, actualCount);
  }
}