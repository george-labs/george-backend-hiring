package counter;

import rule.ignore.WordsToIgnore;
import separator.Separator;

public class WordCounter implements Counter {

  private final Separator delimiterSeparator;
  private final WordsToIgnore wordsToIgnore;

  public WordCounter(final Separator delimiterSeparator, final WordsToIgnore wordsToIgnore) {
    this.delimiterSeparator = delimiterSeparator;
    this.wordsToIgnore = wordsToIgnore;
  }

  public long countWords(final String input) {
    return this.delimiterSeparator.separate(input).stream()
        .filter(word -> word != null
            && !word.isBlank()
            && word.chars().allMatch(Character::isLetter)
            && !this.wordsToIgnore.wordsToIgnoreImmutableValues.contains(word))
        .count();
  }
}
