import static java.util.Collections.emptySet;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import org.junit.jupiter.api.Test;

class WordCounterTest {

  @Test
  void shoudCountWords() {
    WordCounter wordCounter = new WordCounter();

    long count = wordCounter.countWords("Mary had a little lamb & cow", emptySet());

    assertEquals(6, count);
  }

  @Test
  void shouldCountWordsWithoutStoppWords() {
    WordCounter wordCounter = new WordCounter();

    long count = wordCounter.countWords("Mary had a little lamb & cow", Set.of("a"));

    assertEquals(5, count);
  }

}