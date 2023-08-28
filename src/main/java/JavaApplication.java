import gyurix.wordcount.WordCounterConsoleRunner;

import java.io.IOException;

public class JavaApplication {
  public static void main(String[] args) throws IOException {
    new WordCounterConsoleRunner(args).run();
  }
}
