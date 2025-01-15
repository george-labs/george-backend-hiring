import counter.WordCounter;
import input.TerminalInput;
import java.io.IOException;
import java.io.InputStream;
import reader.FileReader;
import reader.LineByLineFileReader;
import rule.Rule;
import rule.factory.RuleFactory;
import separator.DelimiterSeparator;
import separator.Separator;

public class JavaApplication {

  public static void main(String[] args) throws IOException {
    final String pathToIgnoreWordsFile = "src/main/resources/ignoreWords.txt";
    final FileReader reader = new LineByLineFileReader();
    final RuleFactory ruleFactory = new RuleFactory(reader, pathToIgnoreWordsFile);

    final Rule wordsToIgnoreRule = ruleFactory.getWordsToIgnoreRule();
    final Separator separator = new DelimiterSeparator();
    final WordCounter wordCounter = new WordCounter(separator, wordsToIgnoreRule);

    try (final InputStream in = System.in) {
      final TerminalInput terminalInput = new TerminalInput(in);
      final String input = terminalInput.input();
      long count = wordCounter.countWords(input);
      System.out.println("Number of words: " + count);
    }
  }
}
