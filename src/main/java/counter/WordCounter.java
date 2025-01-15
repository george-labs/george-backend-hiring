package counter;

import separator.Separator;

public class WordCounter implements Counter {

  private final Separator separator;

  public WordCounter(final Separator separator) {
    this.separator = separator;
  }

  public long countWords(final String input) {

    return this.separator.separate(input).stream()
        .filter(word -> word.chars().allMatch(Character::isLetter))
        .count();
  }
}
