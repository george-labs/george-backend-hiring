import java.io.IOException;
import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {

        String fileName;
        String input;

        if (args.length > 1) {
            fileName = args[1];
            input
        } else {
            System.out.println("Enter text: ");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
        }

        try {
            var stopWords = StopWordsLoader.loadStopWords();
            var wordProcessor = new WordCounter(input, stopWords);
            wordProcessor.processString();
            var wordCount = wordProcessor.getWordCount();

            System.out.println("Number of words: " + wordCount);
        } catch (IOException e) {
            System.err.println("Encountered an error: " + e.getMessage());
        }

        scanner.close();
    }

}
