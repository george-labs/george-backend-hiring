import textprocessor.WordCounterImpl;
import textprocessor.WordsCounter;

import java.util.Arrays;
import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args) {
        System.out.println("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        WordsCounter counter = new WordCounterImpl();

        System.out.println("Number of words: " + counter.countWords(text));
    }
}
