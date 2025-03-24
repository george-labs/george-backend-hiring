import java.util.Set;

/**
 * Main application class
 */
public class JavaApplication {

  /**
   * Main method to run app.
   *
   * @param args app arguments
   */
  public static void main(String[] args) {
    WordCounter wordCounter = new WordCounter();
    InputReader inputReader = new InputReader();
    StopWordReader stopWordReader = new StopWordReader();

    String input = inputReader.readInput();
    Set<String> stopWords = stopWordReader.readStopWordFile();
    long numberOfWords = wordCounter.countWords(input, stopWords);
    System.out.println("Number of words: " + numberOfWords);
  }
}
