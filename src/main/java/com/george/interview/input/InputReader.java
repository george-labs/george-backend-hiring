package com.george.interview.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputReader {

  private final InputStream input;

  public InputReader(InputStream input) {

    this.input = input;
  }

  public String readLine() throws IOException {

    BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
    return buffer.readLine();
  }
}
