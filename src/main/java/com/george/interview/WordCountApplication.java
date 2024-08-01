package com.george.interview;

import com.george.interview.executor.WordsCountExecutor;
import java.io.IOException;

public class WordCountApplication {

  public static void main(String[] args) throws IOException {

    new WordsCountExecutor().execute();
  }
}
