package counter;

import separator.Separator;

public class WordCounter implements Counter {

  private final Separator delimiterSeparator;

  public WordCounter(final Separator delimiterSeparator) {
    this.delimiterSeparator = delimiterSeparator;
  }

  public long countWords(final String input) {
    return this.delimiterSeparator.separate(input).stream()
        .filter(word -> word.chars().allMatch(Character::isLetter))
        .count();
  }
}
