package com.george.interview;

import com.george.interview.executor.WordsCountExecutor;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordsExecutorIntegrationIteration3Test {

  private WordsCountExecutor executor;

  private ByteArrayOutputStream outputStreamCaptor;

  @BeforeEach
  void setUp() {

    outputStreamCaptor = new ByteArrayOutputStream();
    var wordsFile = getClass().getClassLoader().getResourceAsStream("integration-iteration-3");
    executor = new WordsCountExecutor(wordsFile, new PrintStream(outputStreamCaptor), new String[]{"mytext.txt"});
  }

  @Test
  void iteration3IntegrationTest() {

    executor.execute();
    Assertions.assertEquals("Number of words: 4", outputStreamCaptor.toString());
  }
}
