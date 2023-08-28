package gyurix.wordcount;

import gyurix.wordcount.client.FileInputClient;
import gyurix.wordcount.client.InputClient;
import gyurix.wordcount.client.StringInputClient;
import gyurix.wordcount.dto.WordCounterOutput;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class WordCounterConsoleRunner implements Runnable {
  private String fileName;
  private String dictionary;
  private boolean index;

  public WordCounterConsoleRunner(String[] args) {
    for (String arg : args) {
      if (!arg.startsWith("-") && fileName == null) {
        fileName = arg;
      } else if (arg.equals("-index")) {
        index = true;
      } else if (arg.startsWith("-dictionary=") && dictionary == null) {
        dictionary = arg.substring("-dictionary=".length());
      }
    }
  }

  private void runClientAndShowResult(InputClient inputClient) {
    try {
      inputClient.setDictionary(dictionary);
      DecimalFormat decimalFormat = new DecimalFormat("##0.##");
      WordCounterOutput wordCounterOutput = inputClient.countWords();
      System.out.println("Number of words: " + wordCounterOutput.getWords() +
              ", unique: " + wordCounterOutput.getUniqueWords() +
              ", average word length: " + decimalFormat.format(wordCounterOutput.getAverageWordLength()) + " characters");
      if (index) {
        if (dictionary != null) {
          System.out.println("Index (unknown: " + wordCounterOutput.getWordsNotInDictionary() + "):\n" + String.join("\n", wordCounterOutput.getIndexedWords()));
          return;
        }
        System.out.println("Index:\n" + String.join("\n", wordCounterOutput.getIndexedWords()));
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public String getFileName() {
    return fileName;
  }

  public boolean isIndex() {
    return index;
  }

  public void userInputRunner() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter text: ");
    String inputText = scanner.nextLine();
    runClientAndShowResult(new StringInputClient(inputText));
  }

  public void fileInputRunner() throws IOException {
    runClientAndShowResult(new FileInputClient(fileName));
  }

  @Override
  public void run() {
    if (fileName == null) {
      userInputRunner();
      return;
    }
    try {
      fileInputRunner();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
