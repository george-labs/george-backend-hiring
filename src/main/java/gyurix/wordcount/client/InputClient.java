package gyurix.wordcount.client;

import gyurix.wordcount.WordCounter;
import gyurix.wordcount.dto.WordCounterOutput;

import java.io.IOException;

public abstract class InputClient {
  protected final WordCounter wordCounter = new WordCounter();
  protected String inputData;

  /**
   * Counts the words based on the pre-configured input of the client implementation
   *
   * @return The number of words found in the given input data
   * @throws IOException If there is an error reading the input data
   */
  public WordCounterOutput countWords() throws IOException {
    return wordCounter.countWords(inputData);
  }

  public void setDictionary(String dictionaryFileName) throws IOException {
    if (dictionaryFileName != null) {
      wordCounter.loadDictionary(dictionaryFileName);
    }
  }
}
