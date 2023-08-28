package gyurix.wordcount;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterImplTest {
  private static WordCounter wordCounter;

  @BeforeAll
  public static void setUp() {
    wordCounter = new WordCounterImpl();
  }

  @Test
  public void test1word() {
    assertEquals(1, wordCounter.countWords("word"));
  }

  @Test
  public void test2words() {
    assertEquals(2, wordCounter.countWords("word word"));
  }

  @Test
  public void testWithSpaces() {
    assertEquals(2, wordCounter.countWords("        word         word          "));
  }

  @Test
  public void testSpecialCharacters() {
    assertEquals(1, wordCounter.countWords(" wo3rd wo@@rd word"));
  }

  @Test
  public void testSuffix() {
    assertEquals(0, wordCounter.countWords("word?"));
  }

  @Test
  public void testSuffixCommaSeparated() {
    assertEquals(1, wordCounter.countWords("word, word. word! word? word"));
  }
}
