package com.george.interview.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputReaderTest {

  private InputReader reader;

  @BeforeEach
  void setUp() {

    var inputStream = getClass().getResourceAsStream("input-iteration1.txt");
    reader = new InputReader(inputStream);
  }

  @Test
  void readDataFromISProperly() {

    Assertions.assertEquals("Hello world", reader.readLine());
  }
}