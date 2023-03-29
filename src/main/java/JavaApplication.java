import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JavaApplication {

  public static final String LINE_BREAK = "\n";

  public static void main(String[] args) throws IOException {

    FileInput stopWordsFileInput = new FileInput(FileInput.class.getResourceAsStream("/stopwords.txt"));
    List<String> filterWords;
    try {
      filterWords = Arrays.asList(stopWordsFileInput.readFromFile().split(LINE_BREAK));
    } catch (IOException e) {
      throw new IllegalArgumentException("File not found");
    }

    if (args != null && args.length != 0 && args[0] != null && !args[0].isBlank()) {
      String filePath = args[0];
      FileInput input = new FileInput(new FileInputStream(filePath));
      System.out.println(new WordCounter(filterWords).getCount(input.readFromFile()));
    } else {
      Counter wc = new WordCounter(filterWords);
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter text: ");
      System.out.println("Number of words: " + wc.getCount(scan.nextLine()));
    }
  }

}
