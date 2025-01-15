import counter.WordCounter;
import input.FileInput;
import input.Input;
import input.TerminalInput;
import java.io.IOException;
import reader.FileReader;
import reader.LineByLineFileReader;
import rule.Rule;
import rule.factory.RuleFactory;
import separator.DelimiterSeparator;
import separator.Separator;

public class JavaApplication {

  /**
   * ToDo: Replace with separate processsors for both flows (ex. FileBasedProcessor and TermonalBasedProcerssor) and refactor.
   */
  public static void main(String[] args) throws IOException {
    final String pathToIgnoreWordsFile = "src/main/resources/ignoreWords.txt";
    final FileReader reader = new LineByLineFileReader();
    final RuleFactory ruleFactory = new RuleFactory(reader, pathToIgnoreWordsFile);

    final Rule wordsToIgnoreRule = ruleFactory.getWordsToIgnoreRule();
    final Separator separator = new DelimiterSeparator();
    final WordCounter wordCounter = new WordCounter(separator, wordsToIgnoreRule);

    Input input;
    long count;
    if (args.length > 0) {
      String pathToInputFile = args[0];
      input = new FileInput(reader, pathToInputFile);
      String inputString = input.input();
      count = wordCounter.countWords(inputString);
    } else {
      input = new TerminalInput(System.in);
      final String inputString = input.input();
      count = wordCounter.countWords(inputString);
    }
    System.out.println("Number of words: " + count);
  }
}
