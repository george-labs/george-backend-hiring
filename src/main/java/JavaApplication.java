import java.util.Arrays;
import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        System.out.println("Enter text: ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        var wordProcessor = new WordCounter(input);
        wordProcessor.processString();
        var wordCount = wordProcessor.getWordCount();

        System.out.println("Number of words: " + wordCount);

        scanner.close();
    }

}
