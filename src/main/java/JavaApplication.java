import service.WordCounter;

import java.util.Scanner;

public class JavaApplication {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text:");

        String inputText = scanner.nextLine();
        scanner.close();

        WordCounter wordCounter = new WordCounter();
        System.out.println("Number of words: " + wordCounter.countWords(inputText));
    }
}
