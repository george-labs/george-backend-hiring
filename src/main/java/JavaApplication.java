import java.util.Scanner;
import java.util.logging.Logger;

import managers.FileManager;
import serivces.WordCounter;

public class JavaApplication {

  public static void main(String[] args) {

    Logger log = Logger.getLogger(JavaApplication.class.getName());

    // show the Enter the text
    // read the consoleInput from the user
    Scanner in = new Scanner(System.in);

    // starting text for a user
    log.info("Enter a file name:");

    String consoleInput = in.nextLine();

    // call the service WordCounter with an consoleInput
    WordCounter wordCounter = new WordCounter();

    String input = "";
    if (consoleInput.contains(".txt") && FileManager.isFileInOurResources(consoleInput)) {
      // use file as an consoleInput
      input = FileManager.loadTextFromFile(consoleInput);
    } else {
      log.info("Enter text:");
      // use the consoleInput as it is
      input = in.nextLine();
    }

    // write results to a console
    log.info("Number of words: " + wordCounter.countWords(input));
  }
}
