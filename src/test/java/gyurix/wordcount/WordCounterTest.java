package gyurix.wordcount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {
  private static final WordCounter wordCounter = new WordCounter();

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

  @Test
  public void testNewLineCharacters() {
    assertEquals(7, wordCounter.countWords("line 1\n\rline second\r   \t third line \r fourth line"));
  }
}
