package serivces;

import java.util.Set;

import loaders.StopWordsLoader;

/**
 * WordCounter is a service that counts words in a given text.
 */
public class WordCounter {

  // key = word, value = word
  private final Set<String> setOfStopWords;

  public WordCounter() {
    setOfStopWords = StopWordsLoader.loadStopWords();
  }

  /**
   * calculate number of words in an input
   *
   * @param input - input from a user
   * @return number valid words
   */
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

  /**
   * check if word is valid based on requirements
   * @param item - string
   * @return true if item is a valid word, otherwise false
   */
  private boolean isValidWord(String item) {
    return item.matches("[a-zA-Z]+") && !setOfStopWords.contains(item);
  }
}
