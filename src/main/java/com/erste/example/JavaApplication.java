package com.erste.example;

import com.erste.example.dto.CountHolder;
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
    CountHolder counts = wordCounter.getCounts(inputWords, stopWords);
    System.out.println("Number of words: " + counts.getAllWords() + ", unique: " + counts.getUniqueWords());
  }
}
