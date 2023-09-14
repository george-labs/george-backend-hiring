package model;

/**
 * Model object for a count word response
 */
public class CountWordResponse {

  private int wordCount;
  private int uniqueWordCount;
  private double avgLength;

  public int getWordCount() {
    return wordCount;
  }

  public void setWordCount(int wordCount) {
    this.wordCount = wordCount;
  }

  public int getUniqueWordCount() {
    return uniqueWordCount;
  }

  public void setUniqueWordCount(int uniqueWordCount) {
    this.uniqueWordCount = uniqueWordCount;
  }

  public double getAvgLength() {
    return avgLength;
  }

  public void setAvgLength(double avgLength) {
    this.avgLength = avgLength;
  }
}
