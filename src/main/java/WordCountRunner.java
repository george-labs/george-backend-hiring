import java.util.Scanner;

public class WordCountRunner {
    public static void main(String[] args) {
        WordCount wordCount = WordCount.getInstance();
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        try {
            int count = wordCount.countText(scanner.nextLine());
            System.out.println("Number of words: " + count);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: "+ e.getMessage());
        }
        scanner.close();
    }
}
