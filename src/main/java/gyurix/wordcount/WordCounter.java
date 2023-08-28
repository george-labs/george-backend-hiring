package gyurix.wordcount;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

public class WordCounter {
  private final HashSet<String> stopWords = new HashSet<>();

  public WordCounter() {
    try {
      loadStopWords(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("stopwords.txt")));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void loadStopWords(InputStream stream) throws IOException {
    stopWords.clear();
    byte[] stopWordBytes = stream.readAllBytes();
    Collections.addAll(stopWords, new String(stopWordBytes, StandardCharsets.UTF_8).split("\\s"));
  }

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
