package com.erste.example;

import static java.lang.String.CASE_INSENSITIVE_ORDER;

import com.erste.example.dto.Argument;
import com.erste.example.dto.CountHolder;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Main application class
 */
public class CounterApp {

  public static final String OUTPUT_PLACEHOLDER
      = "Number of words: %s, unique: %s; average word length: %.2f characters";

  private final WordCounter wordCounter;
  private final InputFileReader inputFileReader;
  private final ArgumentsParser argumentParser;

  public CounterApp() {
    this.wordCounter = new WordCounter();
    this.inputFileReader = new InputFileReader();
    this.argumentParser = new ArgumentsParser();
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

    String inputWords = getInputWords(args, inputFileReader);
    Set<String> stopWords = inputFileReader.readStopWordFile();
    CountHolder countHolder = wordCounter.getCounts(inputWords, stopWords);
    System.out.printf(OUTPUT_PLACEHOLDER,
                      countHolder.getAllWords(),
                      countHolder.getUniqueWords(),
                      countHolder.getAverageLenght());
    System.out.println();
    System.out.println("Index:");
    wordCounter.getWordsStream(inputWords, stopWords)
               .sorted(CASE_INSENSITIVE_ORDER)
               .forEachOrdered(System.out::println);
  }


  private String getInputWords(String[] args, InputFileReader inputFileReader) {
    InputReader inputReader = new InputReader();
    String inputWords;
    long count = Stream.of(args)
                       .filter(arg -> arg.contains("-"))
                       .count();
    if (args.length > 0 && count == 1) {
      inputWords = inputFileReader.readInputTextFile(args[0]);
    } else {
      inputWords = inputReader.readInput();
    }
    return inputWords;
  }
}
