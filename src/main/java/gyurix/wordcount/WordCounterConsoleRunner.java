package gyurix.wordcount;

import gyurix.wordcount.client.FileInputClient;
import gyurix.wordcount.client.InputClient;
import gyurix.wordcount.client.StringInputClient;
import gyurix.wordcount.dto.WordCounterOutput;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class WordCounterConsoleRunner {
  private static void runClientAndShowResult(InputClient inputClient) {
    try {
      DecimalFormat decimalFormat = new DecimalFormat("##0.##");
      WordCounterOutput wordCounterOutput = inputClient.countWords();
      System.out.println("Number of words: " + wordCounterOutput.getWords() +
              ", unique: " + wordCounterOutput.getUniqueWords() +
              ", average word length: " + decimalFormat.format(wordCounterOutput.getAverageWordLength()) + " characters");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void userInputRunner() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter text: ");
    String inputText = scanner.nextLine();
    runClientAndShowResult(new StringInputClient(inputText));
  }

  public void fileInputRunner(String fileName) throws IOException {
    runClientAndShowResult(new FileInputClient(fileName));
  }
}
