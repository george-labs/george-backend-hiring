package gyurix.wordcount.dto;

public class WordCounterOutput {
  private int words;
  private int uniqueWords;

  public int getWords() {
    return words;
  }

  public void incWords() {
    this.words += 1;
  }

  public int getUniqueWords() {
    return uniqueWords;
  }

  public void setUniqueWords(int uniqueWords) {
    this.uniqueWords = uniqueWords;
  }
}
