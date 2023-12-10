import java.util.Scanner;

public class WordCountRunner {
    public static void main(String[] args) {
        WordCount wordCount = WordCount.getInstance();
        if (args.length > 0) {
            String filename = args[0];
            if (WordFileReader.isValidFileName(filename)) {
                System.out.println("Number of words: " + wordCount.countText(filename, true));
            } else {
                System.out.println("Invalid filename argument provided");
            }
        } else {
            try {
                System.out.print("Enter text: ");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Number of words: " + wordCount.countText(scanner.nextLine()));
                scanner.close();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }
}
