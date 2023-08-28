import gyurix.wordcount.WordCounter;
import gyurix.wordcount.WordCounterImpl;

import java.io.IOException;
import java.util.Scanner;

public class JavaApplication {
  public static void main(String[] args) throws IOException {
    countWordsFromInputString(new WordCounterImpl());
  }

  public static void countWordsFromInputString(WordCounter wordCounter) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter text: ");
    String inputText = scanner.nextLine();
    int numberOfWords = wordCounter.countWords(inputText);
    System.out.println("Number of words: " + numberOfWords);
  }
}
