package gyurix.wordcount.client;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileInputClientTest {

  @Test
  public void testValidFile() throws IOException {
    assertEquals(4, new FileInputClient("mytext.txt").countWords().getWords());
  }

  @Test
  public void testInvalidFile() {
    assertThrows(FileNotFoundException.class, () -> new FileInputClient("invalid file"));
  }
}
