package george;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordsSplitterTest {

  private WordsSplitter wordsSplitter = new WordsSplitter();

  @Test
  void splitWhen1WordThen1Item() {
    String expected = "qqqq";

    List<String> strings = wordsSplitter.split(expected);

    Assertions.assertEquals(1, strings.size());
    Assertions.assertEquals(expected, strings.get(0));
  }

  @Test
  void splitWhen3WordsThen3Items() {
    List<String> strings = wordsSplitter.split("qqqq 333 gfg>HJUH");

    Assertions.assertEquals(3, strings.size());
  }

  @Test
  void splitWhen2WordsWith2SpacesThen2Items() {
    List<String> strings = wordsSplitter.split("qqqq  ffere");

    Assertions.assertEquals(2, strings.size());
  }

  @Test
  void splitWhenWordWithHyphenThen2Items() {
    List<String> strings = wordsSplitter.split("qqqq-ffere");

    Assertions.assertEquals(2, strings.size());
  }

  @Test
  void splitWhenWordWithDoubleHyphenThen2Items() {
    List<String> strings = wordsSplitter.split("qqqq--ffere");

    Assertions.assertEquals(2, strings.size());
  }

  @Test
  void splitWhenWordWithHyphenOnEdgesThen2Items() {
    List<String> strings = wordsSplitter.split("-qqqq ffere-");

    Assertions.assertEquals(2, strings.size());
  }

  @Test
  void splitWhenTwoWordsAndHyphenThen2Items() {
    List<String> strings = wordsSplitter.split("www - eee");

    Assertions.assertEquals(2, strings.size());
  }
}