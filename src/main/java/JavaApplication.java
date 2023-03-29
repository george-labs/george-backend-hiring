import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JavaApplication {

  public static final String LINE_BREAK = "\n";

  public static void main(String[] args) {

    FileInput fileInput = new FileInput("/stopwords.txt");
    List<String> filterWords;
    try {
      filterWords = Arrays.asList(fileInput.readFromFile().split(LINE_BREAK));
    } catch (IOException e) {
      throw new IllegalArgumentException("File not found");
    }
    Counter wc = new WordCounter(filterWords);
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter text: ");
    System.out.println("Number of words: " + wc.getCount(scan.nextLine()));
  }

}
