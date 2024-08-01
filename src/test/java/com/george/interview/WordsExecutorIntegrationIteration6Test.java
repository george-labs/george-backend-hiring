package com.george.interview;

import com.george.interview.executor.WordsCountExecutor;
import static com.george.interview.executor.WordsCountExecutor.STOP_WORDS_FILE_NAME;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordsExecutorIntegrationIteration6Test {

  private ByteArrayOutputStream outputStreamCaptor;

  @BeforeEach
  void setUp() {

    outputStreamCaptor = new ByteArrayOutputStream();
  }

  @Test
  void iteration4IntegrationTest() {

    var executor = new WordsCountExecutor(null, new PrintStream(outputStreamCaptor), new String[] {"sometext.txt"},
      STOP_WORDS_FILE_NAME);

    executor.execute();
    Assertions.assertEquals("Number of words: 8, unique: 7; average word length: 6.5 characters", outputStreamCaptor.toString());
  }
}
