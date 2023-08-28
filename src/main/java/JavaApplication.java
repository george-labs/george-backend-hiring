import gyurix.wordcount.WordCounterConsoleRunner;

import java.io.IOException;

public class JavaApplication {
  public static void main(String[] args) throws IOException {
    WordCounterConsoleRunner wordCounterConsoleRunner = new WordCounterConsoleRunner();
    if (args.length == 0) {
      wordCounterConsoleRunner.userInputRunner();
      return;
    }
    wordCounterConsoleRunner.fileInputRunner(args[0]);
  }
}
