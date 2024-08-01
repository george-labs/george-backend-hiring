package com.george.interview;

import com.george.interview.executor.WordsCountExecutor;
import static com.george.interview.executor.WordsCountExecutor.STOP_WORDS_FILE_NAME;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordsExecutorStopWordsTest {

  private WordsCountExecutor executor;

  private ByteArrayOutputStream outputStreamCaptor;

  @BeforeEach
  void setUp() {

    outputStreamCaptor = new ByteArrayOutputStream();
    var wordsFile = getClass().getClassLoader().getResourceAsStream("integration-iteration-2");
    executor = new WordsCountExecutor(wordsFile, new PrintStream(outputStreamCaptor), new String[] {}, STOP_WORDS_FILE_NAME);
  }

  @Test
  void nullStopWordsFileDoesNotBreakTheImplementation() {

    var wordsFile = getClass().getClassLoader().getResourceAsStream("integration-iteration-2");
    executor = new WordsCountExecutor(wordsFile, new PrintStream(outputStreamCaptor), new String[] {}, null);
    executor.execute();
    Assertions.assertEquals("Enter text: Number of words: 5, unique: 5", outputStreamCaptor.toString());
  }

  @Test
  void notExistingStopWordsFileDoesNotBreakTheImplementation() {

    var wordsFile = getClass().getClassLoader().getResourceAsStream("integration-iteration-2");
    executor = new WordsCountExecutor(wordsFile, new PrintStream(outputStreamCaptor), new String[] {}, "file-that-does-not-exist");
    executor.execute();
    Assertions.assertEquals("Enter text: Number of words: 5, unique: 5", outputStreamCaptor.toString());
  }
}
