package com.erste.example.dto;

public class CountHolder {

  private long allWords;
  private long uniqueWords;

  public CountHolder(long allWords, long uniqueWords) {
    this.allWords = allWords;
    this.uniqueWords = uniqueWords;
  }

  public long getAllWords() {
    return allWords;
  }

  public long getUniqueWords() {
    return uniqueWords;
  }

}
