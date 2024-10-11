import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter text: ");
        String text = scanner.nextLine();

        int words = WordCounter.countWords(text);
        System.out.println("Number of words: " + words);
    }
}
