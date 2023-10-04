package george;

public class JavaApplication {

  public static void main(String[] args) {

    TextReader reader = new TextReader();
    WordCounter counter = new WordCounter();

    String text = reader.read();
    int count = counter.count(text);

    System.out.println("Number of words: " + count);
  }
}
