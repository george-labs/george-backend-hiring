package com.george.interview;

import com.george.interview.counter.WordsCounter;
import com.george.interview.input.InputReader;
import java.io.IOException;

public class WordCountApplication {

  public static void main(String[] args) throws IOException {

    InputReader reader = new InputReader(System.in);
    WordsCounter counter = new WordsCounter();

    System.out.print("Enter text: ");

    var message = reader.readLine();
    var wordCount = counter.countWords(message);

    System.out.format("Number of words: %d", wordCount);
  }
}
