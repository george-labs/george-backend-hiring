package serivce;

import java.util.logging.Logger;

/**
 * WordCounter is a service that counts words in a given text.
 */
public class WordCounter {

  Logger logger = Logger.getLogger(WordCounter.class.getName());

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
    return item.matches("[a-zA-Z]+");
  }
}
