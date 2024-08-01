package com.george.interview.executor;

import com.george.interview.counter.WordsCounter;
import com.george.interview.input.InputReader;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Set;

public class WordsCountExecutor {

  private static final String STOP_WORDS_FILE_NAME = "stopwords.txt";

  private final InputStream userInput;

  private final PrintStream userOutput;

  private final String[] commandLineInput;

  public WordsCountExecutor(InputStream userInput, PrintStream out, String[] commandLineInput) {

    this.userInput = userInput;
    this.userOutput = out;
    this.commandLineInput = commandLineInput;
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

    userOutput.format("Number of words: %d", wordCount);
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

    var initialFile = new File(STOP_WORDS_FILE_NAME);
    var targetStream = new FileInputStream(initialFile);
    return reader.readFileAsWords(targetStream);
  }
}
