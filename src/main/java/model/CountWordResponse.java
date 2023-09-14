package model;

import java.util.HashSet;
import java.util.Set;

/**
 * Model object for a count word response
 */
public class CountWordResponse {

  private int wordCount;
  private Set<String> uniqueWords;
  private double avgLength;

  public int getWordCount() {
    return wordCount;
  }

  public void setWordCount(int wordCount) {
    this.wordCount = wordCount;
  }

  public Set<String> getUniqueWords() {
    if (null == uniqueWords) {
      return new HashSet<>();
    }

    return uniqueWords;
  }

  public void setUniqueWords(Set<String> uniqueWords) {
    this.uniqueWords = uniqueWords;
  }

  public double getAvgLength() {
    return avgLength;
  }

  public void setAvgLength(double avgLength) {
    this.avgLength = avgLength;
  }
}
