package gyurix.wordcount.client;

import gyurix.wordcount.WordCounter;
import gyurix.wordcount.dto.WordCounterOutput;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * A client used for counting words from an input string representing the name of the file from which we want to read our data
 */
public class FileInputClient implements InputClient {
  private final WordCounter wordCounter = new WordCounter();
  private final String inputData;

  public FileInputClient(String fileName) throws IOException {
    try (FileInputStream fis = new FileInputStream(fileName)) {
      byte[] fileData = fis.readAllBytes();
      inputData = new String(fileData, StandardCharsets.UTF_8);
    }
  }

  @Override
  public WordCounterOutput countWords() {
    return wordCounter.countWords(inputData);
  }
}
