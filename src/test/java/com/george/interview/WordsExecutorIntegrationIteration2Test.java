package com.george.interview;

import com.george.interview.executor.WordsCountExecutor;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordsExecutorIntegrationIteration2Test {

  private WordsCountExecutor executor;

  private ByteArrayOutputStream outputStreamCaptor;

  @BeforeEach
  void setUp() {

    outputStreamCaptor = new ByteArrayOutputStream();
    var wordsFile = getClass().getClassLoader().getResourceAsStream("integration-iteration-2");
    executor = new WordsCountExecutor(wordsFile, new PrintStream(outputStreamCaptor), new String[] {});
  }

  @Test
  void iteration2IntegrationTest() {

    executor.execute();
    Assertions.assertEquals("Enter text: Number of words: 4, unique: 4", outputStreamCaptor.toString());
  }
}
