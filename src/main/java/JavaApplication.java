import java.util.List;
import java.util.Scanner;

public class JavaApplication {

    static final WordCounter wordCounter = new WordCounter();
    static final FileReader fileReader = new FileReader();
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> words;
        if (args.length != 0) {
            String filePath = args[0];
            String fileResult = fileReader.getSentenceFromFile(filePath);
            words = wordCounter.filterWords(fileResult);
            System.out.println("Number of words: " + wordCounter.countWords(words) + "" +
                    ", unique: " + wordCounter.countUniqueWords(words) + "" +
                    "; average word length: " + wordCounter.countAvgLength(words));
        } else {
            System.out.println("Enter text: ");
            words = wordCounter.filterWords(scanner.nextLine());
            System.out.println("Number of words: " + wordCounter.countWords(words) + "" +
                    ", unique: " + wordCounter.countUniqueWords(words) + "" +
                    "; average word length: " + wordCounter.countAvgLength(words));
        }
    }
}
