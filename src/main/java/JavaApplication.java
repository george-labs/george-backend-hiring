public class JavaApplication {

  public static void main(String[] args) {
    WordCounter wordCounter = new WordCounter();
    InputReader inputReader = new InputReader();
    String input = inputReader.readInput();
    long numberOfWords = wordCounter.countWords(input);
    System.out.println("Number of words: " + numberOfWords);
  }
}
