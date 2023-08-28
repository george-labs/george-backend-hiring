package gyurix.wordcount.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringInputClientTest {

  @Test
  public void testZeroWords() {
    assertEquals(0, new StringInputClient("zero.words").countWords());
  }

  @Test
  public void testTwoLetterWord() {
    assertEquals(2, new StringInputClient("invalid file").countWords());
  }
}
