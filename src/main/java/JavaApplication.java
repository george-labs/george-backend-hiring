import counter.WordCounter;

import java.io.IOException;
import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounter();
        try {
            wordCounter.loadStopWords();
        } catch (final IOException ioException) {
            throw new IllegalArgumentException(String.format("Path is not found"));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = scanner.nextLine();
        int count = wordCounter.countWordsExcludingStopWords(text);
        System.out.println("Number of words: " + count);
    }

}
