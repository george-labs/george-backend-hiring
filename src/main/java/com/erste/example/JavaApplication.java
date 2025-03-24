package com.erste.example;

import java.util.Set;

/**
 * Main application class
 */
public class JavaApplication {

  /**
   * Main method to run app.
   *
   * @param args app arguments
   */
  public static void main(String[] args) {
    WordCounter wordCounter = new WordCounter();
    InputReader inputReader = new InputReader();
    InputFileReader inputFileReader = new InputFileReader();

    String inputWords;
    if (args.length == 1) {
      inputWords = inputFileReader.readInputTextFile(args[0]);
    } else {
      inputWords = inputReader.readInput();
    }
    Set<String> stopWords = inputFileReader.readStopWordFile();
    long numberOfWords = wordCounter.countWords(inputWords, stopWords);
    long numberOfUniqueWords = wordCounter.countUniqueWords(inputWords, stopWords);
    System.out.println("Number of words: " + numberOfWords + ", unique: " + numberOfUniqueWords);
  }
}
