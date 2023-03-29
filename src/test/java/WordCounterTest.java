import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.george.wordcounter.WordCounter;
import org.junit.jupiter.api.Test;

class WordCounterTest {

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

    wordCount = wc.getCount("This-is-not-a-word");
    assertEquals(0, wordCount);
  }

  @Test
  void word_count_should_be_correct_when_filtered() {
    List<String> filters = new ArrayList<>();
    filters.add("the");
    filters.add("a");
    filters.add("on");
    filters.add("off");
    WordCounter wc = new WordCounter(filters);

    long wordCount = wc.getCount("This is a test");
    assertEquals(3, wordCount);

    wordCount = wc.getCount("the a on off");
    assertEquals(0, wordCount);

    wordCount = wc.getCount("This is an test");
    assertEquals(4, wordCount);

    wordCount = wc.getCount(null);
    assertEquals(0, wordCount);
  }

}
