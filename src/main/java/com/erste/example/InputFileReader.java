package com.erste.example;

import static java.util.Collections.emptySet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class for reading file.
 */
public class InputFileReader {

  /**
   * Reads stop words from stopwords.txt file.
   *
   * @param fileName name of file
   * @return stop words
   */
  public Set<String> readStopWordFile(String fileName) {
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      return br.lines()
               .collect(Collectors.toSet());
    } catch (java.io.IOException e) {
      System.out.println("Caught exception during file " + fileName + " reading: " + e);
      return emptySet();
    }
  }


  /**
   * Reads input words from provided file.
   *
   * @return input words
   */
  public String readInputTextFile(String fileName) {
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      return br.lines()
               .collect(Collectors.joining(" "));
    } catch (java.io.IOException e) {
      System.out.println("Caught exception during file " + fileName + " reading: " + e);
      throw new RuntimeException("Problem with reading file: " + fileName);
    }
  }
}