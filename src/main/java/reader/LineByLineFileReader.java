package reader;

import exception.IgnoreFileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LineByLineFileReader implements FileReader {

  @Override
  public List<String> read(final String pathToFile) {
    try {
      return Files.readAllLines(Paths.get(pathToFile));
    } catch (IOException ex) {
      throw new IgnoreFileNotFoundException(pathToFile);
    }
  }
}
