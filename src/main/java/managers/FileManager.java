package managers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Class to load stop words from a file
 */
public class FileManager {

  static Logger logger = Logger.getLogger(FileManager.class.getName());

  /**
   * Load stop words from a file
   *
   * @return Set of stop words
   */
  public static Set<String> loadStopWords() {
    Set<String> stopWordMap = new HashSet<>();

    // load String from stop words file
    String stopWords = loadTextFromFile("stopwords.txt");

    // split the whole string into items without spaces
    String[] result = stopWords.split("\\s+");

    Collections.addAll(stopWordMap, result);

    return stopWordMap;
  }

  /**
   * Load input file into String
   *
   * @param fileName - name of the file
   * @return String with the content of the file
   */
  public static String loadTextFromFile(String fileName) {
    StringBuilder builder = new StringBuilder();

    try {
      BufferedReader reader = getBufferedReader(fileName);
      String line = reader.readLine();

      while (line != null) {
        // add line to the builder
        builder.append(line);
        builder.append(" ");

        line = reader.readLine();
      }
    } catch (IOException e) {
      logger.warning("Error reading file: " + e.getMessage());
    }

    return builder.toString();
  }

  /**
   * Get BufferedReader from a specific file
   *
   * @param fileName - name of the file
   * @return BufferedReader
   */
  private static BufferedReader getBufferedReader(String fileName) {
    InputStream is = FileManager.class.getClassLoader().getResourceAsStream(fileName);
    InputStreamReader isr = new InputStreamReader(Objects.requireNonNull(is));
    return new BufferedReader(isr);
  }

  /**
   * Check if file is in our resources
   *
   * @param fileName - name of the file
   * @return true if file is in our resources, false otherwise
   */
  public static boolean isFileInOurResources(String fileName) {
    return FileManager.class.getClassLoader().getResource(fileName) != null;
  }
}
