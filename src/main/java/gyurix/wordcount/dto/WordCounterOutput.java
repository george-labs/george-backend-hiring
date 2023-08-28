package gyurix.wordcount.dto;

public class WordCounterOutput {
  private int words;
  private int uniqueWords;

  private int totalWordLength;

  public int getWords() {
    return words;
  }

  public void addWord(int wordLength) {
    this.words += 1;
    this.totalWordLength += wordLength;
  }

  public double getAverageWordLength() {
    return totalWordLength * 1.0 / Math.max(1, words);
  }

  public int getUniqueWords() {
    return uniqueWords;
  }

  public void setUniqueWords(int uniqueWords) {
    this.uniqueWords = uniqueWords;
  }
}
