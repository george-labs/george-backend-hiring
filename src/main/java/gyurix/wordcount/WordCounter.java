package gyurix.wordcount;

import gyurix.wordcount.dto.WordCounterOutput;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

  public WordCounterOutput countWords(String in) {
    WordCounterOutput wordCounterOutput = new WordCounterOutput();
    Set<String> uniqueWords = new HashSet<>();
    for (String word : in.split("[\\s.]+")) {
      if (word.matches("^[a-zA-Z\\-]+$") && !stopWords.contains(word.toLowerCase())) {
        wordCounterOutput.incWords();
        uniqueWords.add(word.toLowerCase());
      }
    }
    wordCounterOutput.setUniqueWords(uniqueWords.size());
    return wordCounterOutput;
  }
}
