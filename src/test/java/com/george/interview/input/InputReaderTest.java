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

  @Test
  void readAllWordsFromFile() {

    var inputStream = getClass().getClassLoader().getResourceAsStream("stopwords.txt");
    var words = reader.readFileAsWords(inputStream);
    Assertions.assertEquals(4, words.size());
  }
}