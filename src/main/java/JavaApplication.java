import counter.WordCounter;
import input.TerminalInput;
import java.io.IOException;
import java.io.InputStream;
import separator.DelimiterSeparator;
import separator.Separator;

public class JavaApplication {

  public static void main(String[] args) throws IOException {
    final Separator separator = new DelimiterSeparator();
    final WordCounter wordCounter = new WordCounter(separator);

    try(final InputStream in = System.in) {
      final TerminalInput terminalInput = new TerminalInput(in);
      final String input = terminalInput.input();
      long count = wordCounter.countWords(input);
      System.out.println("Number of words: " + count);
    }
  }
}
