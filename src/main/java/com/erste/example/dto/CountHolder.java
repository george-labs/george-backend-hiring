package com.erste.example.dto;

public class CountHolder {

  private final long allWords;
  private final long uniqueWords;
  private final Double averageLenght;

  public CountHolder(long allWords, long uniqueWords, Double averageLenght) {
    this.allWords = allWords;
    this.uniqueWords = uniqueWords;
    this.averageLenght = averageLenght;
  }

  public long getAllWords() {
    return allWords;
  }

  public long getUniqueWords() {
    return uniqueWords;
  }

  public Double getAverageLenght() {
    return averageLenght;
  }
}
