package gyurix.wordcount;

import gyurix.wordcount.client.FileInputClient;
import gyurix.wordcount.client.InputClient;
import gyurix.wordcount.client.StringInputClient;
import gyurix.wordcount.dto.WordCounterOutput;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class WordCounterConsoleRunner implements Runnable {
  private final String fileName;
  private final boolean index;

  public WordCounterConsoleRunner(String[] args) {
    List<String> argList = List.of(args);
    int indexId = argList.indexOf("-index");
    index = indexId != -1;
    if (args.length == 0 || args.length == 1 && index) {
      fileName = null;
      return;
    }
    fileName = indexId == 0 ? args[1] : args[0];
  }

  private static void runClientAndShowResult(InputClient inputClient, boolean showIndex) {
    try {
      DecimalFormat decimalFormat = new DecimalFormat("##0.##");
      WordCounterOutput wordCounterOutput = inputClient.countWords();
      System.out.println("Number of words: " + wordCounterOutput.getWords() + ", unique: " + wordCounterOutput.getUniqueWords() +
              ", average word length: " + decimalFormat.format(wordCounterOutput.getAverageWordLength()) + " characters");
      if (showIndex) {
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
    runClientAndShowResult(new StringInputClient(inputText), index);
  }

  public void fileInputRunner() throws IOException {
    runClientAndShowResult(new FileInputClient(fileName), index);
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
