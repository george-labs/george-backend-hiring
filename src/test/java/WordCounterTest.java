import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WordCounterTest {

  @Test
  void shoudCountWords(){
    WordCounter wordCounter = new WordCounter();

    long count = wordCounter.countWords("Mary had a little lamb & cow");

    assertEquals(6, count);
  }

}