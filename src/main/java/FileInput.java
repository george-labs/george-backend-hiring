import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileInput {

  private final String filePath;

  public FileInput(String filePath) {
    this.filePath = filePath;
  }

  public String readFromFile() throws IOException {
    StringBuilder resultStringBuilder = new StringBuilder();

    if (filePath == null) {
      throw new IllegalArgumentException("File path must not be null");
    }

    try (InputStream inputStream = FileInput.class.getResourceAsStream(this.filePath)) {

      if (inputStream == null)
        throw new IllegalArgumentException("File with given path does not exist: " + this.filePath);

      try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
        String line;
        while ((line = br.readLine()) != null) {
          resultStringBuilder.append(line).append(Constants.LINE_BREAK);
        }
      }
    }
    return resultStringBuilder.toString();
  }

}
