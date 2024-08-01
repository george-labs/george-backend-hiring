package com.george.interview.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputReader {

  public String readLine(InputStream input) throws IOException {

    BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
    return buffer.readLine();
  }
}