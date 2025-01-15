package rule.ignore;

import java.util.Collections;
import java.util.List;
import rule.Rule;

public class WordsToIgnoreRule implements Rule {

  private final List<String> wordsToIgnoreImmutableValues;

  public WordsToIgnoreRule(final List<String> wordsToIgnoreImmutableValues) {
    this.wordsToIgnoreImmutableValues = Collections.unmodifiableList(wordsToIgnoreImmutableValues);
  }

  @Override
  public boolean validate(final String string) {
    return !this.wordsToIgnoreImmutableValues.contains(string);
  }
}
