import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaApplicationTest {

  @Test
  void dummy_test() {

  }

  @Test
  void word_count_should_be_correct() {
    WordCounter wc = new WordCounter();

    long wordCount = wc.getCount("This is a test");
    assertEquals(4, wordCount);

    wordCount = wc.getCount(" ");
    assertEquals(0, wordCount);

    wordCount = wc.getCount("    This is    a test");
    assertEquals(4, wordCount);

    wordCount = wc.getCount(null);
    assertEquals(0, wordCount);

    wordCount = wc.getCount("Th1s is not a w0rd");
    assertEquals(3, wordCount);

    wordCount = wc.getCount("Th1s 1s n0t 4 w0rd");
    assertEquals(0, wordCount);
  }

}
