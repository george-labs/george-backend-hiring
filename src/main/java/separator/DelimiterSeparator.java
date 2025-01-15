package separator;

import exception.NullInputException;
import java.util.List;

public class DelimiterSeparator implements Separator {
  private final String allowedSeparators = "[\\s]";

  public List<String> separate(final String input) {
    if (input == null) {
      throw new NullInputException();
    }
    return List.of(input.split(allowedSeparators));
  }
}
