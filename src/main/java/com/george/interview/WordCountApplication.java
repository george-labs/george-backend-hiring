package com.george.interview;

import com.george.interview.executor.WordsCountExecutor;

public class WordCountApplication {

  public static void main(String[] args) {

    new WordsCountExecutor(System.in, System.out, args).execute();
  }
}
