package com.george.interview;

import com.george.interview.executor.WordsCountExecutor;
import static com.george.interview.executor.WordsCountExecutor.STOP_WORDS_FILE_NAME;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordsExecutorIntegrationIteration4Test {

  private ByteArrayOutputStream outputStreamCaptor;

  @BeforeEach
  void setUp() {

    outputStreamCaptor = new ByteArrayOutputStream();
  }

  @Test
  void iteration4IntegrationTest() {

    var wordsFile = getClass().getClassLoader().getResourceAsStream("integration-iteration-4");
    var executor = new WordsCountExecutor(wordsFile, new PrintStream(outputStreamCaptor), new String[] {}, STOP_WORDS_FILE_NAME);

    executor.execute();
    Assertions.assertEquals("Enter text: Number of words: 7, unique: 6", outputStreamCaptor.toString());
  }
}
