package counter;

import rule.Rule;
import separator.Separator;

public class WordCounter implements Counter {

  private final Separator delimiterSeparator;
  private final Rule wordsToIgnoreRule;

  public WordCounter(final Separator delimiterSeparator, final Rule wordsToIgnoreRule) {
    this.delimiterSeparator = delimiterSeparator;
    this.wordsToIgnoreRule = wordsToIgnoreRule;
  }

  public long countWords(final String input) {
    return this.delimiterSeparator.separate(input).stream()
        .filter(word -> word != null
            && !word.isBlank()
            && word.chars().allMatch(Character::isLetter)
            && this.wordsToIgnoreRule.validate(word))
        .count();
  }
}
