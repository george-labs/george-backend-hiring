import counter.WordCounter;

import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounter();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = scanner.nextLine();
        int count = wordCounter.countWords(text);
        System.out.println("Number of words: " + count);
    }

}
