import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args) {
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        WordCounter counter = new WordCounter();
        int wordCount = counter.count(text);
        System.out.println("Number of words: " + wordCount);
    }
}
