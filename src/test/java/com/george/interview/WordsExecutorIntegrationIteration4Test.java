package com.george.interview;

import com.george.interview.executor.WordsCountExecutor;
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
  void iteration3IntegrationTest() {

    var wordsFile = getClass().getClassLoader().getResourceAsStream("integration-iteration-4");
    var executor = new WordsCountExecutor(wordsFile, new PrintStream(outputStreamCaptor), new String[] {});

    executor.execute();
    Assertions.assertEquals("Enter text: Number of words: 9, unique: 7", outputStreamCaptor.toString());
  }
}
