package george;

import java.util.Arrays;
import java.util.List;

public class WordsSplitter {

  public List<String> split(String text) {
    return Arrays.asList(text.split("\\s+"));
  }

}
