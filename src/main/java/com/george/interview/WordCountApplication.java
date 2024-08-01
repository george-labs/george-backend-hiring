package com.george.interview;

import com.george.interview.input.InputReader;
import java.io.IOException;

public class WordCountApplication {

  public static void main(String[] args) throws IOException {

    InputReader reader = new InputReader(System.in);
    var message = reader.readLine();
    System.out.println(message);
  }
}
