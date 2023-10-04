package george;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordCounterTest {

  private WordCounter wordCounter = new WordCounter();

  @Test
  void countWhen1WordThen1() {
    int count = wordCounter.count("qqqq");

    Assertions.assertEquals(1, count);
  }

  @Test
  void countWhen3WordsThen3() {
    int count = wordCounter.count("qqqq 333 gfg>HJUH");

    Assertions.assertEquals(3, count);
  }

  @Test
  void countWhen2WordsWith2Space2Then2() {
    int count = wordCounter.count("qqqq  ffere");

    Assertions.assertEquals(2, count);
  }

}