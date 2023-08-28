package gyurix.wordcount.client;

import gyurix.wordcount.WordCounter;

/**
 * A client used for counting words from a direct string input
 */
public class StringInputClient implements InputClient {
  private final WordCounter wordCounter = new WordCounter();
  private final String inputText;

  public StringInputClient(String inputText) {
    this.inputText = inputText;
  }


  @Override
  public int countWords() {
    return wordCounter.countWords(inputText);
  }
}
