import java.util.Scanner;

public class JavaApplication {

    static final WordCounter wordCounter = new WordCounter();
    static final FileReader fileReader = new FileReader();
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        if (args.length != 0) {
            String filePath = args[0];
            String fileResult = fileReader.getSentenceFromFile(filePath);
            System.out.println("Number of words: " + wordCounter.countWords(fileResult) + ", unique: " + wordCounter.countUniqueWords(fileResult));
        } else {
            System.out.println("Enter text: ");
            String userInput = scanner.nextLine();
            System.out.println("Number of words: " + wordCounter.countWords(userInput) + ", unique: " + wordCounter.countUniqueWords(userInput));
        }
    }
}
