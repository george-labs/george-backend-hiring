package george;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordsFilter {

  private Set<String> words;

  public WordsFilter(Set<String> words) {
    this.words = words;
  }

  public List<String> filter(List<String> strings) {
    return strings.stream().filter(word -> !words.contains(word)).collect(Collectors.toList());
  }
}
