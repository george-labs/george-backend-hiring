package george.filter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class UniquenessWordsFilter implements WordFilter {

  @Override
  public List<String> filter(List<String> words) {
    Map<String, Long> wordsCount = new HashMap<>();

    for (String word : words) {
      Long count = wordsCount.getOrDefault(word, 0L);
      wordsCount.put(word, ++count);
    }

    List<String> uniqWords = wordsCount.entrySet().stream()
        .filter(entry -> entry.getValue() == 1)
        .map(Entry::getKey)
        .collect(Collectors.toList());

    return uniqWords;
  }
}
