package george.words;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class WordsFileReader {

  private String filename;

  public WordsFileReader(String filename) {
    this.filename = filename;
  }

  public List<String> read() {
    try {
      List<String> strings = Files.readAllLines(Paths.get(filename));
      return strings.stream().filter(string -> !string.isBlank()).collect(Collectors.toList());
    } catch (IOException e) {
      throw new RuntimeException("Failed to read file: " + filename, e);
    }
  }

}
