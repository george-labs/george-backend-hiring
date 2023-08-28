package gyurix.wordcount;

import gyurix.wordcount.dto.WordCounterOutput;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class WordCounter {
  private final Set<String> stopWords = new HashSet<>();

  private Set<String> dictionary;

  public WordCounter() {
    try {
      loadStopWords(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("stopwords.txt")));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void loadDictionary(String fileName) throws IOException {
    try (FileInputStream fis = new FileInputStream(fileName)) {
      dictionary = Set.of(new String(fis.readAllBytes(), StandardCharsets.UTF_8).split("\\s"));
    }
  }

  public void loadStopWords(InputStream stream) throws IOException {
    stopWords.clear();
    byte[] stopWordBytes = stream.readAllBytes();
    Collections.addAll(stopWords, new String(stopWordBytes, StandardCharsets.UTF_8).split("\\s"));
  }

  private boolean isWordInDictionary(String lowercaseWord) {
    return dictionary == null || dictionary.contains(lowercaseWord);
  }

  public WordCounterOutput countWords(String in) {
    WordCounterOutput wordCounterOutput = new WordCounterOutput();
    Map<String, String> uniqueWords = new TreeMap<>();
    for (String word : in.split("[\\s.]+")) {
      if (word.matches("^[a-zA-Z\\-]+$") && !stopWords.contains(word.toLowerCase())) {
        wordCounterOutput.addWord(word.length());
        String wordLowerCase = word.toLowerCase();
        uniqueWords.putIfAbsent(wordLowerCase, isWordInDictionary(wordLowerCase) ? word : word + "*");
      }
    }
    wordCounterOutput.setUniqueWords(uniqueWords.size());
    wordCounterOutput.setIndexedWords(new ArrayList<>(uniqueWords.values()));
    return wordCounterOutput;
  }
}
