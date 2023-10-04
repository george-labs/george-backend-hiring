package george.filter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StopWordsFilter implements WordFilter {

  private Set<String> words;

  public StopWordsFilter(Set<String> words) {
    this.words = words;
  }

  @Override
  public List<String> filter(List<String> strings) {
    return strings.stream().filter(word -> !words.contains(word)).collect(Collectors.toList());
  }
}
