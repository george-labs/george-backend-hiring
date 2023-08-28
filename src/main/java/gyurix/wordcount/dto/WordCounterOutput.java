package gyurix.wordcount.dto;

import java.util.List;

public class WordCounterOutput {
  private int words;
  private int uniqueWords;
  private int wordsNotInDictionary;
  private int totalWordLength;
  private List<String> indexedWords;

  public int getWordsNotInDictionary() {
    return wordsNotInDictionary;
  }

  public List<String> getIndexedWords() {
    return indexedWords;
  }

  public void setIndexedWords(List<String> indexedWords) {
    this.indexedWords = indexedWords;
  }

  public int getWords() {
    return words;
  }

  public void addWord(int wordLength) {
    this.words += 1;
    this.totalWordLength += wordLength;
  }

  public void incWordsNotInDictionary() {
    ++wordsNotInDictionary;
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
