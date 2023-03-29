package com.george.wordcounter;

import static java.util.Arrays.asList;

import java.util.List;

public class WordCounter implements Counter {


  private List<String> filters;
  public WordCounter(List<String> filters) {
    this.filters = filters;
  }

  public WordCounter() {

  }

  @Override
  public long getCount(String input) {
    if (input == null || input.isBlank())
      return 0;
    input = input.replace("\n", " ");
    List<String> stringSplit = asList(input.split(Constants.SPACE));
    return stringSplit.stream().filter(this::isAlpha).filter(s -> !isSkipWord(s)).count();
  }

  private boolean isAlpha(String name) {
    return name.matches("[a-zA-Z]+");
  }

  private boolean isSkipWord(String word) {
    if (filters == null)
      return false;
    return filters.contains(word);
  }
}
