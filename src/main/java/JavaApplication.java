import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

import managers.FileManager;
import model.CountWordResponse;
import serivces.WordCounter;

public class JavaApplication {

  public static void main(String[] args) {

    Logger log = Logger.getLogger(JavaApplication.class.getName());

    // print index
    boolean printIndex = false;

    // call the service WordCounter with an consoleInput
    WordCounter wordCounter = new WordCounter();

    String input = "";

    // if there is a name of the file in args, use that as an input
    if (args.length > 0) {
      if (args.length == 1) {
        // args equals -index
        if (args[0].equals("-index")) {
          printIndex = true;

          // TODO: duplicate code, put into another method and re-use it
          // continue with the Scanner
          // show the start text
          log.info("Enter text:");
          Scanner in = new Scanner(System.in);

          input = in.nextLine();
        } else {
          input = FileManager.loadTextFromFile(args[0]);
        }
      } else if (args.length == 2) {
        // if args contains -index, use all others as an input
        if (Arrays.asList(args).contains("-index")) {
          printIndex = true;
          for (String arg : args) {
            if (!arg.equals("-index")) {
              input = FileManager.loadTextFromFile(arg);
            }
          }
        }
      } else {
        log.warning("Wrong number of arguments");
      }
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
        "Number of words: " + countWordResponse.getWordCount() + ", unique: " + countWordResponse.getUniqueWords()
            .size()
            + "; average word length: " + avg + " characters");

    if (printIndex) {
      log.info("Index: ");
      // TODO: sort index values
      for (String indexWord : countWordResponse.getUniqueWords()) {
        log.info(indexWord);
      }
    }
  }
}
