package input;

import java.io.IOException;
import reader.FileReader;

public class FileInput implements Input {

  private final FileReader fileReader;
  private final String pathToFile;

  public FileInput(final FileReader fileReader, final String pathToFile) {
    this.fileReader = fileReader;
    this.pathToFile = pathToFile;
  }

  @Override
  public String input() throws IOException {
    return this.fileReader.read(this.pathToFile).stream()
        .reduce((a, b) -> a + " " + b).orElse("");
  }
}
