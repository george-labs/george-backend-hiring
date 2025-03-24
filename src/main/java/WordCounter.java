import java.util.stream.Stream;

public class WordCounter {

  public long countWords(String input) {
    return Stream.of(input.split(" "))
                 .filter(s -> s.matches("[a-zA-Z]+"))
                 .count();
  }
}
