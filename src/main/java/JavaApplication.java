public class JavaApplication {

  public static void main(String[] args) {
    WordCounter wordCounter = new WordCounter();
    InputReader inputReader = new InputReader();
    StpWordReader stpWordReader = new StopWordReader();

    String input = inputReader.readInput();
    long numberOfWords = wordCounter.countWords(input);
    System.out.println("Number of words: " + numberOfWords);
  }
}
