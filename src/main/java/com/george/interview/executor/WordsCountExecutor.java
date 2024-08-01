package com.george.interview.executor;

import com.george.interview.counter.WordsCounter;
import com.george.interview.input.InputReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Set;

public class WordsCountExecutor {

  public static final String STOP_WORDS_FILE_NAME = "stopwords.txt";

  private final InputStream userInput;

  private final PrintStream userOutput;

  private final String[] commandLineInput;

  private final String stopWordsFileName;

  public WordsCountExecutor(InputStream userInput, PrintStream outputStream, String[] commandLineInput, String stopWordsFileName) {

    checkNullabilityOfDependencies(userInput, outputStream, commandLineInput);
    this.userInput = userInput;
    this.userOutput = outputStream;
    this.commandLineInput = commandLineInput;
    this.stopWordsFileName = stopWordsFileName;
  }

  private void checkNullabilityOfDependencies(InputStream userInput, PrintStream outputStream, String[] commandLineInput) {

    if (outputStream == null) {
      throw new IllegalArgumentException("output cannot be null");
    }
    if (commandLineInput == null) {
      throw new IllegalArgumentException("command line input cannot be null");
    }
  }

  public void execute() {

    try {
      executeInternal();
    } catch (IOException e) {
      System.err.format("There was a problem with reading specific file, message: %s%n", e.getMessage());
    }
  }

  private void executeInternal() throws IOException {

    InputReader reader = new InputReader();
    var ignoredWords = readIgnoreWordsFile(reader);

    WordsCounter counter = new WordsCounter(ignoredWords);

    var message = extractMessage(reader);
    var wordCount = counter.countWords(message);

    userOutput.format("Number of words: %d, unique: %d"
        + "; average word length: %.2f characters", wordCount.wordCount(), wordCount.uniqueWords()
      , wordCount.avgWordLength());
  }

  private String extractMessage(InputReader reader) throws IOException {

    if (commandLineInput.length == 0) {
      userOutput.print("Enter text: ");
      return reader.readLine(userInput);
    } else {
      return reader.readWholeFile(commandLineInput[0]);
    }
  }

  private Set<String> readIgnoreWordsFile(InputReader reader) throws IOException {

    if (stopWordsFileName == null) {
      return Collections.emptySet();
    }
    var initialFile = new File(stopWordsFileName);

    if (!initialFile.exists()) {
      return Collections.emptySet();
    }

    var targetStream = new FileInputStream(initialFile);
    return reader.readFileAsWords(targetStream);
  }
}
