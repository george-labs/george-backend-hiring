package gyurix.wordcount;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterImplTest {
  private static WordCounter wordCounter;

  @BeforeAll
  public static void setUp() throws IOException {
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

  @Test
  public void testStopWord() {
    assertEquals(4, wordCounter.countWords("Mary had the little lamb"));
    assertEquals(4, wordCounter.countWords("Mary had a little lamb"));
    assertEquals(4, wordCounter.countWords("Mary had on little lamb on   on "));
    assertEquals(4, wordCounter.countWords("Mary had off little off lamb"));
  }
}
