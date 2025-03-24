package com.erste.example;

import static java.lang.String.CASE_INSENSITIVE_ORDER;

import com.erste.example.dto.Argument;
import com.erste.example.dto.CountHolder;
import java.util.List;
import java.util.Set;

/**
 * Main application class
 */
public class CounterApp {

  public static final String OUTPUT_PLACEHOLDER
      = "Number of words: %s, unique: %s; average word length: %.2f characters";

  private final WordCounter wordCounter;
  private final InputFileReader inputFileReader;
  private final ArgumentsParser argumentParser;
  private final InputReader inputReader;

  public CounterApp() {
    this.wordCounter = new WordCounter();
    this.inputFileReader = new InputFileReader();
    this.argumentParser = new ArgumentsParser();
    this.inputReader = new InputReader();
  }

  /**
   * Main method to run app.
   *
   * @param args app arguments
   */
  public static void main(String[] args) {
    CounterApp counterApp = new CounterApp();
    counterApp.count(args);
  }

  private void count(String[] args) {
    List<Argument> arguments = argumentParser.parseArguments(args);
    String inputWords = getInputWords(arguments);

    Set<String> stopWords = inputFileReader.readStopWordFile();
    CountHolder countHolder = wordCounter.getCounts(inputWords, stopWords);
    System.out.printf(OUTPUT_PLACEHOLDER,
                      countHolder.getAllWords(),
                      countHolder.getUniqueWords(),
                      countHolder.getAverageLenght());
    System.out.println();
    outputWhenFiltered(arguments, inputWords, stopWords);
  }

  private String getInputWords(List<Argument> arguments) {
    return arguments.stream()
                    .filter(argument -> argument.getName().equals("filename"))
                    .findFirst()
                    .map(arg -> inputFileReader.readInputTextFile(arg.getValue()))
                    .orElseGet(inputReader::readInput);
  }

  private void outputWhenFiltered(List<Argument> arguments, String inputWords, Set<String> stopWords) {
    arguments.stream()
             .filter(argument -> argument.getName().equals("index"))
             .findFirst()
             .ifPresent(filter -> {
               System.out.println("Index:");
               wordCounter.getWordsStream(inputWords, stopWords)
                          .sorted(CASE_INSENSITIVE_ORDER)
                          .forEachOrdered(System.out::println);
             });
  }
}
