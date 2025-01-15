package rule.ignore;

import java.util.Collections;
import java.util.List;

public class WordsToIgnore {

  public final List<String> wordsToIgnoreImmutableValues;

  public WordsToIgnore(final List<String> wordsToIgnoreImmutableValues) {
    this.wordsToIgnoreImmutableValues = Collections.unmodifiableList(wordsToIgnoreImmutableValues);
  }
}
