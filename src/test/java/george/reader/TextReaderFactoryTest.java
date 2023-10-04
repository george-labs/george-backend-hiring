package george.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TextReaderFactoryTest {

  @Test
  void createConsoleReader() {
    TextReader reader = TextReaderFactory.createReader(null);

    Assertions.assertInstanceOf(TextConsoleReader.class, reader);
  }

  @Test
  void createFileReader() {
    TextReader reader = TextReaderFactory.createReader("file.txt");

    Assertions.assertInstanceOf(TextFileReader.class, reader);
  }
}