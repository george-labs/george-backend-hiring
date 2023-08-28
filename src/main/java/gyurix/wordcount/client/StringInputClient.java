package gyurix.wordcount.client;

/**
 * A client used for counting words from a direct string input
 */
public class StringInputClient extends InputClient {
  public StringInputClient(String inputText) {
    this.inputData = inputText;
  }
}
