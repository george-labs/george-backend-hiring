package com.george.interview.input;

import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputReaderTest {

  private InputReader reader;

  @BeforeEach
  void setUp() {
    reader = new InputReader();
  }

  @Test
  void readDataFromISProperly() throws IOException {

    var inputStream = getClass().getClassLoader().getResourceAsStream("input-iteration1.txt");
    Assertions.assertEquals("Hello world", reader.readLine(inputStream));
  }
}