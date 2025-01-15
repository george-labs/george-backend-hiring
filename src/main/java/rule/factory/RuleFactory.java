package rule.factory;

import java.util.List;
import reader.FileReader;
import rule.Rule;
import rule.ignore.WordsToIgnoreRule;

public class RuleFactory {

  private final String wordsToIgnorePath;
  private final FileReader fileReader;

  public RuleFactory(final FileReader fileReader, final String wordsToIgnorePath) {
    this.fileReader = fileReader;
    this.wordsToIgnorePath = wordsToIgnorePath;
  }

  public Rule getWordsToIgnoreRule() {
    List<String> wordsToIgnore = this.fileReader.read(this.wordsToIgnorePath);
    return new WordsToIgnoreRule(wordsToIgnore);
  }
}
