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
    InputFileReader stopWordReader = new InputFileReader();

    String inputWords;
    if (args.length == 1) {
      inputWords = stopWordReader.readInputTextFile(args[0]);
    } else {
      inputWords = inputReader.readInput();
    }
    Set<String> stopWords = stopWordReader.readStopWordFile();
    long numberOfWords = wordCounter.countWords(inputWords, stopWords);
    System.out.println("Number of words: " + numberOfWords);
  }
}
