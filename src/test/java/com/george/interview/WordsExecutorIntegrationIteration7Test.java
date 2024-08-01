package com.george.interview;

import com.george.interview.executor.WordsCountExecutor;
import static com.george.interview.executor.WordsCountExecutor.STOP_WORDS_FILE_NAME;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordsExecutorIntegrationIteration7Test {

  private ByteArrayOutputStream outputStreamCaptor;

  @BeforeEach
  void setUp() {

    outputStreamCaptor = new ByteArrayOutputStream();
  }

  @Test
  void iteration6IntegrationTest() {

    var wordsFile = getClass().getClassLoader().getResourceAsStream("integration-iteration-2");
    var executor = new WordsCountExecutor(wordsFile, new PrintStream(outputStreamCaptor), new String[] {"-index"},
      STOP_WORDS_FILE_NAME);

    executor.execute();
    Assertions.assertEquals(
      "Enter text: Number of words: 4, unique: 4; average word length: 4.25 characters",
      outputStreamCaptor.toString());
  }
}
