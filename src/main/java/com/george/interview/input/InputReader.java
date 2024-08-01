package com.george.interview.input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public class InputReader {

  public String readLine(InputStream input) throws IOException {

    checkNullity(input);
    try (var is = new InputStreamReader(input);
         var buffer = new BufferedReader(is)) {
      return buffer.readLine();
    }
  }

  private void checkNullity(Object input) {

    if (input == null) {
      throw new IllegalArgumentException("Input cannot be null");
    }
  }

  public Set<String> readFileAsWords(InputStream input) throws IOException {

    checkNullity(input);
    try (var is = new InputStreamReader(input);
         var buffer = new BufferedReader((is))) {
      return buffer.lines().collect(Collectors.toSet());
    }
  }

  public String readWholeFile(String fileNameToRead) throws IOException {

    checkNullity(fileNameToRead);
    StringBuilder content = new StringBuilder();
    try (var fis = new FileInputStream(fileNameToRead);
         var bis = new BufferedReader(new InputStreamReader(fis))) {
      String line = bis.readLine();
      while (line != null) {
        content.append(line).append(System.lineSeparator());
        line = bis.readLine();
      }
    }
    return content.toString();
  }
}
