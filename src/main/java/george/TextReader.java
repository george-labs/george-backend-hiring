package george;

import java.io.Console;

public class TextReader {

  public String read() {
    Console console = System.console();
    return console.readLine("Enter text: ");
  }
}
