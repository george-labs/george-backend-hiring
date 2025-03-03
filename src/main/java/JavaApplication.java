import java.util.List;
import java.util.Scanner;

public class JavaApplication {

    public static final String TEXT_FILE_PATH = "src/main/resources/mytext.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileReader fileReader = new FileReader();

        WordCounter wordCounter = new WordCounter();
        List<String> stopWords = fileReader.getStopWords(TEXT_FILE_PATH);

        String line = null;
        if (TEXT_FILE_PATH != null) {
            line = fileReader.getContent(TEXT_FILE_PATH);
        } else {
            System.out.print("Enter text: ");
            line = sc.nextLine();
        }
        System.out.println("Number of words: " + wordCounter.count(line, stopWords));
    }
}
