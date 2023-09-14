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

    // TODO: refactor, fix getter in CountWordResponse to not use this extra set
    Set<String> uniqueWords = new HashSet<>();
    double totalLength = 0;

    // for loop through items, and check they are correct words
    for (String item : result) {
      if (isValidWord(item)) {
        response.setWordCount(response.getWordCount() + 1);
        uniqueWords.add(item);
        totalLength += item.length();
      }
    }

    response.setUniqueWords(uniqueWords);

    // set average length
    if (response.getWordCount() != 0) {
      response.setAvgLength(totalLength / response.getWordCount());
    }

    return response;
  }

  /**
   * check if word is valid based on requirements
   *
   * @param item - string
   * @return true if item is a valid word, otherwise false
   */
  private boolean isValidWord(String item) {
    // - is not a valid word
    if (item.equals("-")) {
      return false;
    }

    return item.matches("[a-zA-Z-]+") && !setOfStopWords.contains(item);
  }
}
