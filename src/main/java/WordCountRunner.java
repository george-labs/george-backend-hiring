import java.util.Scanner;

public class WordCountRunner {
    public static void main(String[] args) {
        WordCount wordCount = WordCount.getInstance();
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Number of words: " + wordCount.countText(scanner.nextLine()));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}
