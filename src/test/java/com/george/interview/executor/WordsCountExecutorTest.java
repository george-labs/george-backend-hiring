package com.george.interview.executor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordsCountExecutorTest {

  @Test
  void useNullInputStream() {

    Assertions.assertThrows(IllegalArgumentException.class, () -> new WordsCountExecutor(null, null, null));
  }

  @Test
  void useNullOutputStream() {

    Assertions.assertThrows(IllegalArgumentException.class, () -> new WordsCountExecutor(System.in, null, null));
  }

  @Test
  void useNullCommandLineArgumentsStream() {

    Assertions.assertThrows(IllegalArgumentException.class, () -> new WordsCountExecutor(System.in, System.out, null));
  }
}
