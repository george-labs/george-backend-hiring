package com.george.interview;

import com.george.interview.executor.WordsCountExecutor;
import static com.george.interview.executor.WordsCountExecutor.STOP_WORDS_FILE_NAME;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordsExecutorStopWordsTest {

  private ByteArrayOutputStream outputStreamCaptor;

  @BeforeEach
  void setUp() {

    outputStreamCaptor = new ByteArrayOutputStream();
  }

  @Test
  void nullStopWordsFileDoesNotBreakTheImplementation() {

    var wordsFile = getClass().getClassLoader().getResourceAsStream("integration-iteration-2");
    var executor = new WordsCountExecutor(wordsFile, new PrintStream(outputStreamCaptor), new String[] {}, null);
    executor.execute();
    Assertions.assertEquals("Enter text: Number of words: 5, unique: 5; average word length: 3.60 characters", outputStreamCaptor.toString());
  }

  @Test
  void notExistingStopWordsFileDoesNotBreakTheImplementation() {

    var wordsFile = getClass().getClassLoader().getResourceAsStream("integration-iteration-2");
    var executor = new WordsCountExecutor(wordsFile, new PrintStream(outputStreamCaptor), new String[] {}, "file-that-does-not-exist");
    executor.execute();
    Assertions.assertEquals(
      "Enter text: Number of words: 5, unique: 5; average word length: 3.60 characters",
      outputStreamCaptor.toString());
  }
}
