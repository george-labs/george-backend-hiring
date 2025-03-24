package com.erste.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Set;
import org.junit.jupiter.api.Test;

class StopWordReaderTest {

  @Test
  public void shouldReadStopWordsFile() {
    InputFileReader stopWordReader = new InputFileReader();

    Set<String> stopWords = stopWordReader.readStopWordFile();

    assertEquals(4, stopWords.size());
  }


  @Test
  public void shouldReadInputFileWhenFileExists() {
    InputFileReader stopWordReader = new InputFileReader();

    String input = stopWordReader.readInputTextFile("mytext.txt");

    assertEquals("Mary has a little sheep and cow", input);
  }

  @Test
  public void shouldReadInputFileWhenFileNotExists() {
    InputFileReader stopWordReader = new InputFileReader();

    RuntimeException runtimeException = assertThrows(RuntimeException.class,
                                                     () -> stopWordReader.readInputTextFile("mytext2.txt"));

    assertEquals("Problem with reading file: mytext2.txt", runtimeException.getMessage());
  }

}