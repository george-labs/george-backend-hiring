import java.io.IOException;
import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text:");

        String inputText = scanner.nextLine();

        System.out.println("Number of words: " + new WordCounter().count(inputText));

    }
}
