package separator;

import java.util.List;

public class Separator {
  private final String allowedSeparators = "[\\s]";

  public List<String> separate(final String input) {
    return List.of(input.split(allowedSeparators));
  }
}
