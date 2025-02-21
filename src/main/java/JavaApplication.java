import sk.erste.wordcountkata.WordCounter;

import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        System.out.print("Enter text: ");

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        WordCounter wordCounter = new WordCounter(text);
        int count = wordCounter.countWords();

        System.out.println("Number of words: " + count);
    }

}
