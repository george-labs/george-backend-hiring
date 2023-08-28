package gyurix.wordcount.client;

import gyurix.wordcount.dto.WordCounterOutput;

import java.io.IOException;

public interface InputClient {
  /**
   * Counts the words based on the pre-configured input of the client implementation
   *
   * @return The number of words found in the given input data
   * @throws IOException If there is an error reading the input data
   */
  WordCounterOutput countWords() throws IOException;
}
