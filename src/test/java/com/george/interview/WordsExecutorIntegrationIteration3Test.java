package com.george.interview;

import com.george.interview.executor.WordsCountExecutor;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordsExecutorIntegrationIteration3Test {

  private ByteArrayOutputStream outputStreamCaptor;

  @BeforeEach
  void setUp() {

    outputStreamCaptor = new ByteArrayOutputStream();
  }

  @Test
  void iteration3IntegrationTest() {

    var wordsFile = getClass().getClassLoader().getResourceAsStream("integration-iteration-3");
    var executor = new WordsCountExecutor(wordsFile, new PrintStream(outputStreamCaptor), new String[] {"mytext.txt"});

    executor.execute();
    Assertions.assertEquals("Number of words: 4, unique: 4", outputStreamCaptor.toString());
  }

  @Test
  void iteration3NotExistingFileIsProvided() {

    var wordsFile = getClass().getClassLoader().getResourceAsStream("integration-iteration-3-no-existing-file");
    var executor = new WordsCountExecutor(wordsFile, new PrintStream(outputStreamCaptor), new String[] {"not-existing-file"});
    Assertions.assertDoesNotThrow(executor::execute);
    Assertions.assertTrue(outputStreamCaptor.toString().isBlank());
  }
}
