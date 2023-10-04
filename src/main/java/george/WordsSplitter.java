package george;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordsSplitter {

  public List<String> split(String text) {
    List<String> words = Arrays.asList(text.split("[\\s-]+"));

    return words.stream().filter(word -> !word.isEmpty()).collect(Collectors.toList());
  }

}
