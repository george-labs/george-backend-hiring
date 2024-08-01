package com.george.interview.executor;

import com.george.interview.counter.WordsCounter;
import com.george.interview.input.InputReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class WordsCountExecutor {

  private static final String STOP_WORDS_FILE_NAME = "stopwords.txt";

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

    WordsCounter counter = new WordsCounter(new HashSet<>());

    System.out.print("Enter text: ");

    var message = reader.readLine(System.in);
    var wordCount = counter.countWords(message);

    System.out.format("Number of words: %d", wordCount);
  }

  private Set<String> readIgnoreWordsFile(InputReader reader) throws IOException {

    var initialFile = new File(STOP_WORDS_FILE_NAME);
    var targetStream = new FileInputStream(initialFile);
    return reader.readFileAsWords(targetStream);
  }
}
