package george.reader;

import java.io.Console;

public class TextConsoleReader implements TextReader {

  @Override
  public String read() {
    Console console = System.console();
    return console.readLine("Enter text: ");
  }
}
