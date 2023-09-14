import java.util.Scanner;
import java.util.logging.Logger;

import managers.FileManager;
import model.CountWordResponse;
import serivces.WordCounter;

public class JavaApplication {

  public static void main(String[] args) {

    Logger log = Logger.getLogger(JavaApplication.class.getName());

    // call the service WordCounter with an consoleInput
    WordCounter wordCounter = new WordCounter();

    String input = "";

    // if there is a name of the file in args, use that as an input
    if (args.length > 0) {
      input = FileManager.loadTextFromFile(args[0]);
    } else {
      // continue with the Scanner
      // show the start text
      log.info("Enter text:");
      Scanner in = new Scanner(System.in);

      input = in.nextLine();
    }

    CountWordResponse countWordResponse = wordCounter.countWords(input);

    String avg = String.format("%.2f", countWordResponse.getAvgLength());

    // write results to a console
    log.info(
        "Number of words: " + countWordResponse.getWordCount() + ", unique: " + countWordResponse.getUniqueWordCount()
            + "; average word length: " + avg + " characters");
  }
}
