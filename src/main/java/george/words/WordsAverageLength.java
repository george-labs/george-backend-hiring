package george.words;

import java.util.List;

public class WordsAverageLength {

  public double calculate(List<String> words) {
    if (words.isEmpty()) {
      return 0.0;
    }

    double average = 0.0;

    for (String word : words) {
      average += word.length();
    }

    return average / words.size();
  }
}
