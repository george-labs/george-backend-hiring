package com.george.interview.executor;

import static com.george.interview.executor.WordsCountExecutor.STOP_WORDS_FILE_NAME;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordsCountExecutorTest {

  @Test
  void useNullInputStream() {

    Assertions.assertThrows(IllegalArgumentException.class, () -> new WordsCountExecutor(null, null, null, STOP_WORDS_FILE_NAME));
  }

  @Test
  void useNullOutputStream() {

    Assertions.assertThrows(IllegalArgumentException.class, () -> new WordsCountExecutor(System.in, null, null, STOP_WORDS_FILE_NAME));
  }

  @Test
  void useNullCommandLineArgumentsStream() {

    Assertions.assertThrows(IllegalArgumentException.class, () -> new WordsCountExecutor(System.in, System.out, null, STOP_WORDS_FILE_NAME));
  }
}
