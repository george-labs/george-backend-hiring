package george;

public class WordCounter {

  public int count(String text) {
    String[] strings = text.split("\\s+");
    return strings.length;
  }

}
