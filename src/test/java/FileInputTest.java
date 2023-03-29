import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FileInputTest {

  @Test
  void read_from_file_should_return_contents() {
    FileInput fi = new FileInput(FileInput.class.getResourceAsStream("/stopwords.txt"));
    try {
      String contents = fi.readFromFile();
      assertNotNull(contents);
      assertFalse(contents.isEmpty());
      assertTrue(contents.contains("the"));
      assertTrue(contents.contains("on"));
      assertTrue(contents.contains("off"));
      assertTrue(contents.contains("a"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  void read_from_null_path_should_throw_exception() {
    FileInput fi = new FileInput(null);
    IllegalArgumentException iae = Assertions.assertThrows(IllegalArgumentException.class, fi::readFromFile);
    assertEquals("Input stream must not be null", iae.getMessage());
  }

}
