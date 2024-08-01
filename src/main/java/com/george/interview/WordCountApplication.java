package com.george.interview;

import com.george.interview.counter.WordsCounter;
import com.george.interview.input.InputReader;
import java.io.IOException;
import java.util.HashSet;

public class WordCountApplication {

  public static void main(String[] args) throws IOException {

    InputReader reader = new InputReader();
    WordsCounter counter = new WordsCounter(new HashSet<>());

    System.out.print("Enter text: ");

    var message = reader.readLine(System.in);
    var wordCount = counter.countWords(message);

    System.out.format("Number of words: %d", wordCount);
  }
}
