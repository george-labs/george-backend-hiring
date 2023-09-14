package loaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Class to load stop words from a file
 */
public class StopWordsLoader {

  static Logger logger = Logger.getLogger(StopWordsLoader.class.getName());

  public static Set<String> loadStopWords() {
    Set<String> stopWordMap = new HashSet<>();

    try {
      InputStream is = StopWordsLoader.class.getClassLoader().getResourceAsStream("stopwords.txt");
      if (null == is) {
        logger.warning("File not found");
        return stopWordMap;
      }

      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader reader = new BufferedReader(isr);

      String line = reader.readLine();

      while (line != null) {
        // add to the map before reading another line
        stopWordMap.add(line);

        // add stop word to a map
        line = reader.readLine();
      }
    } catch (IOException e) {
      logger.warning("Error reading file: " + e.getMessage());
    }

    return stopWordMap;
  }
}
