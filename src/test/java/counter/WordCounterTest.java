package counter;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordCounterTest {

  private WordCounter wordCounter;
  private MockedSeparator separator;

  @BeforeEach
  void beforeEach() {
    this.separator = new MockedSeparator();
    this.wordCounter = new WordCounter(this.separator);
  }

  @Test
  void testWordCount() {
    final String testString = "oleg is on a interview";
    final List<String> separatedString = List.of("oleg", "is", "on", "a", "interview");
    this.separator.setMockedSeparatedStrings(separatedString);

    long actualCount = this.wordCounter.countWords(testString);
    long expectedCount = 5;
    Assertions.assertEquals(expectedCount, actualCount);
  }
}