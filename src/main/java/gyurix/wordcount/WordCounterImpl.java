package gyurix.wordcount;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

public class WordCounterImpl implements WordCounter {
  private final HashSet<String> stopWords = new HashSet<>();

  public WordCounterImpl() throws IOException {
    loadStopWords();
  }

  private void loadStopWords() throws IOException {
    stopWords.clear();
    byte[] stopWordBytes = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("stopwords.txt")).readAllBytes();
    Collections.addAll(stopWords, new String(stopWordBytes, StandardCharsets.UTF_8).split("\\s"));
  }

  @Override
  public int countWords(String in) {
    int wordCount = 0;
    for (String word : in.split("\\s")) {
      if (word.matches("^[a-zA-Z]+$") && !stopWords.contains(word.toLowerCase())) {
        ++wordCount;
      }
    }
    return wordCount;
  }
}
