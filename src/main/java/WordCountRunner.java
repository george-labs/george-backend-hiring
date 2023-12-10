import java.util.Scanner;

public class WordCountRunner {
    private static final WordCount wordCount = WordCount.getInstance();

    private static void handleFileNameInput(String fileName) {
        if (WordFileReader.isValidFileName(fileName)) {
            System.out.println("Number of words: " + wordCount.countText(fileName, true));
        } else {
            System.out.println("Invalid filename argument provided");
        }
    }

    public static void handleTextInput() {
        try {
            System.out.print("Enter text: ");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Number of words: " + wordCount.countText(scanner.nextLine()));
            scanner.close();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            handleFileNameInput(args[0]);
        } else {
            handleTextInput();
        }
    }
}
