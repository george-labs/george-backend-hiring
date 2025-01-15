package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TerminalInput implements Input {

  private InputStream inputStream;

  public TerminalInput(final InputStream inputStream) {
    this.inputStream = inputStream;
  }

  @Override
  public String input() throws IOException {
    // Enter data using BufferReader
    try (BufferedReader r = new BufferedReader(new InputStreamReader(this.inputStream))) {
      return r.readLine();
    }
  }
}
