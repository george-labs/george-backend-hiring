package george.reader;

import george.TextReader;

public class TextReaderFactory {

  public static TextReader createReader(String filename) {
    if (filename == null || filename.isEmpty()) {
      return new TextConsoleReader();
    } else {
      return new TextFileReader(filename);
    }
  }

}
