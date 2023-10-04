package george.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TextFileReaderTest {

  @Test
  void readFileWithSingleLine() {
    TextFileReader textFileReader = new TextFileReader(
        "src/test/resources/george/reader/singleLine.txt");

    String string = textFileReader.read();
    Assertions.assertEquals("qq ww", string);
  }

  @Test
  void readFileWithMultipleLines() {
    TextFileReader textFileReader = new TextFileReader(
        "src/test/resources/george/reader/multipleLines.txt");

    String string = textFileReader.read();
    Assertions.assertEquals("qq ww 44 55 3f", string);
  }
}