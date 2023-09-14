package serivces;

import java.util.HashSet;
import java.util.Set;

import managers.FileManager;
import model.CountWordResponse;

/**
 * WordCounter is a service that counts words in a given text.
 */
public class WordCounter {

  // set of stop words
  private final Set<String> setOfStopWords;

  public WordCounter() {
    setOfStopWords = FileManager.loadStopWords();
  }

  /**
   * calculate number of words in an input
   *
   * @param input - input from a user
   * @return number valid words
   */
  public CountWordResponse countWords(String input) {
    CountWordResponse response = new CountWordResponse();

    // check if null or empty
    if (null == input || input.isEmpty()) {
      return response;
    }

    // split the whole string into items without spaces based on multiple delimiters
    String[] result = input.split("[\\s+.?!,;:]");

    Set<String> setOfUniqueWords = new HashSet<>();

    // for loop through items, and check they are correct words
    for (String item : result) {
      if (isValidWord(item)) {
        response.setWordCount(response.getWordCount()+1);
        setOfUniqueWords.add(item);
      }
    }

    response.setUniqueWordCount(setOfUniqueWords.size());
    return response;
  }

  /**
   * check if word is valid based on requirements
   *
   * @param item - string
   * @return true if item is a valid word, otherwise false
   */
  private boolean isValidWord(String item) {
    if (item.equals("-")) {
      return false;
    }

    return item.matches("[a-zA-Z-]+") && !setOfStopWords.contains(item);
  }
}
