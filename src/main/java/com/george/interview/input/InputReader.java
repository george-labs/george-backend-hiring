package com.george.interview.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public class InputReader {

  public String readLine(InputStream input) throws IOException {

    BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
    return buffer.readLine();
  }

  public Set<String> readFileAsWords(InputStream inputStream) throws IOException {

    BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
    return buffer.lines().collect(Collectors.toSet());
  }
}
