package gyurix.wordcount.client;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringInputClientTest {

  @Test
  public void testZeroWords() throws IOException {
    assertEquals(0, new StringInputClient("zero*words").countWords().getWords());
  }

  @Test
  public void testTwoLetterWord() throws IOException {
    assertEquals(2, new StringInputClient("invalid file").countWords().getWords());
  }
}