import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class StopWordReader {

  public ArrayList<String> readStopWordFile() throws java.io.IOException {
    ArrayList<String> stopWords = new java.util.ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("stopwords.txt"))) {
      StringBuilder sb = new StringBuilder();
      String line = br.readLine();
      stopWords.add(line);
    }
    return stopWords;
  }
}