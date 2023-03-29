import static java.util.Arrays.asList;

import java.util.List;

public class WordCounter implements Counter {

  private static final String SPACE = " ";

  @Override
  public long getCount(String input) {
    if (input == null || input.isBlank())
      return 0;
    List<String> stringSplit = asList(input.split(SPACE));
    return stringSplit.stream().filter(this::isAlpha).count();
  }

  private boolean isAlpha(String name) {
    return name.matches("[a-zA-Z]+");
  }
}
