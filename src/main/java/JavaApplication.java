import java.util.Scanner;

public class JavaApplication {

    static final WordCounter wordCounter = new WordCounter();
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter text: ");
        System.out.println("Number of words: " + wordCounter.countWords(scanner.nextLine()));
    }
}
