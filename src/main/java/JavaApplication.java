import java.util.Scanner;
import java.util.logging.Logger;

import serivces.WordCounter;

public class JavaApplication {

  public static void main(String[] args) {

    Logger log = Logger.getLogger(JavaApplication.class.getName());

    // show the Enter the text
    // read the input from the user
    Scanner in = new Scanner(System.in);

    log.info("Enter text");

    String input = in.nextLine();

    // call the service WordCounter with an input
    WordCounter wordCounter = new WordCounter();

    // write results to a console
    log.info("Number of words: " + wordCounter.countWords(input));
  }
}
