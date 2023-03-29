package com.george.wordcounter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.george.wordcounter.providers.FileProvider;
import com.george.wordcounter.providers.InputProvider;
import com.george.wordcounter.providers.ProviderFactory;

public class JavaApplication {

  public static final String LINE_BREAK = "\n";

  public static void main(String[] args) throws IOException {

    InputProvider stopWordsInputProvider = new FileProvider(FileProvider.class.getResourceAsStream("/stopwords.txt"));
    List<String> filterWords;
    try {
      filterWords = Arrays.asList(stopWordsInputProvider.readFromInput().split(LINE_BREAK));
    } catch (IOException e) {
      throw new IllegalArgumentException("File not found");
    }

    InputProvider inputProvider = ProviderFactory.create(args);
    Counter wc = new WordCounter(filterWords);

    System.out.println("Number of words: " + wc.getCount(inputProvider.readFromInput()));

  }

}

