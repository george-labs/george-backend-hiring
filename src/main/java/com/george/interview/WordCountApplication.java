package com.george.interview;

import com.george.interview.executor.WordsCountExecutor;
import static com.george.interview.executor.WordsCountExecutor.STOP_WORDS_FILE_NAME;

public class WordCountApplication {

  public static void main(String[] args) {

    new WordsCountExecutor(System.in, System.out, args, STOP_WORDS_FILE_NAME).execute();
  }
}
