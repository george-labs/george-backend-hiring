import java.util.List;
import java.util.Scanner;

public class JavaApplication {

    static final WordCounter wordCounter = new WordCounter();
    static final FileReader fileReader = new FileReader();
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String filePath = args[0];
        String fileResult = fileReader.getSentenceFromFile(filePath);
        if (!fileResult.isEmpty()) {
            System.out.println("Number of words: " + wordCounter.countWords(fileResult));
        } else {
            System.out.println("Enter text: ");
            System.out.println("Number of words: " + wordCounter.countWords(scanner.nextLine()));
        }
    }
}
