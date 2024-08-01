package com.george.interview.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public class InputReader {

  public String readLine(InputStream input) throws IOException {

    checkNullityOfInput(input);
    BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
    return buffer.readLine();
  }

  private void checkNullityOfInput(InputStream input) {

    if (input == null) {
      throw new IllegalArgumentException("Input cannot be null");
    }
  }

  public Set<String> readFileAsWords(InputStream input) throws IOException {

    checkNullityOfInput(input);
    BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
    return buffer.lines().collect(Collectors.toSet());
  }
}
