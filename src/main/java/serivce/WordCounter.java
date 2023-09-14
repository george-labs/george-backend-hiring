package serivce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * WordCounter is a service that counts words in a given text.
 */
public class WordCounter {

  Logger logger = Logger.getLogger(WordCounter.class.getName());

  // key = word, value = word
  private final Map<String, String> map = new HashMap<>();

  public WordCounter() {
    loadStopWords();
  }

  private void loadStopWords() {
    try {
      InputStream is = this.getClass().getResourceAsStream("/stopwords.txt");
      if (null == is) {
        logger.warning("File not found");
        return;
      }

      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader reader = new BufferedReader(isr);

      String line = reader.readLine();

      while (line != null) {
        // add to the map before reading another line
        map.put(line, line);

        // add stop word to a map
        line = reader.readLine();

      }
    } catch (IOException e) {
      logger.warning("Error reading file");
    }
  }

  public int countWords(String input) {
    int resultCount = 0;

    // check if null or empty
    if (null == input || input.isEmpty()) {
      return resultCount;
    }

    // split the whole string into items without spaces
    String[] result = input.split("\\s+");

    // for loop through items, and check they are correct words
    for (String item : result) {
      if (isValidWord(item)) {
        resultCount++;
      }
    }

    return resultCount;
  }

  private boolean isValidWord(String item) {
    return item.matches("[a-zA-Z]+") && !map.containsKey(item);
  }
}
