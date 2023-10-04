package george.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextFileReader implements TextReader {

  private String filename;

  public TextFileReader(String filename) {
    this.filename = filename;
  }

  @Override
  public String read() {
    try {
      List<String> strings = Files.readAllLines(Paths.get(filename));

      StringBuilder stringBuilder = new StringBuilder();
      for (String string : strings) {
        stringBuilder.append(string).append(" ");
      }

      return stringBuilder.toString().trim();
    } catch (IOException e) {
      throw new RuntimeException("Failed to read file: " + filename, e);
    }
  }
}
