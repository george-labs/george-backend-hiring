package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalInput implements Input {


  @Override
  public String input() throws IOException {
    // Enter data using BufferReader
    try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
      return r.readLine();
    }
  }
}
