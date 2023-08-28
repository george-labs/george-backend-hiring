package gyurix.wordcount;

public class WordCounterImpl implements WordCounter {
  @Override
  public int countWords(String in) {
    int wordCount = 0;
    for (String word : in.split("\\s")) {
      if (word.matches("^[a-zA-Z]+$")) {
        ++wordCount;
      }
    }
    return wordCount;
  }
}
