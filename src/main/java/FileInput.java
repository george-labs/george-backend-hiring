import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileInput {

  private final InputStream inputStream;

  public FileInput(InputStream inputStream) {
    this.inputStream = inputStream;
  }

  /**
   * Loads and splits the file on line breaks
   *
   * @return returns contents of a file
   * @throws IllegalArgumentException when file path is null or file does not exist
   */
  public String readFromFile() throws IOException {
    StringBuilder resultStringBuilder = new StringBuilder();

    if (this.inputStream == null) {
      throw new IllegalArgumentException("Input stream must not be null");
    }

    try (BufferedReader br = new BufferedReader(new InputStreamReader(this.inputStream))) {
      String line;
      while ((line = br.readLine()) != null) {
        resultStringBuilder.append(line).append(Constants.LINE_BREAK);
      }
    }

    return resultStringBuilder.toString();
  }

}
