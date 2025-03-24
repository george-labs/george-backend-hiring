import static java.util.Collections.emptySet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class for reading file.
 */
public class StopWordReader {

  /**
   * Reads stop words from stopwords.txt file.
   *
   * @return stop words
   */
  public Set<String> readStopWordFile() {
    try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/stopwords.txt"))) {
      return br.lines()
               .collect(Collectors.toSet());
    } catch (java.io.IOException e) {
      System.out.println("Caought exception during file reading: " + e);
      return emptySet();
    }
  }
}