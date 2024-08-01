package com.george.interview.input;

import java.io.IOException;
import java.util.List;
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
  void readAllWordsFromFile() throws IOException {

    var inputStream = getClass().getClassLoader().getResourceAsStream("stopwords.txt");
    var words = reader.readFileAsWords(inputStream);
    Assertions.assertEquals(4, words.size());
    Assertions.assertTrue(words.containsAll(List.of("the", "a", "on", "off")));
  }
}