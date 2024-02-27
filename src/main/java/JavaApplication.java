import counter.WordCounter;
import util.FileReaderUtil;

import java.io.IOException;
import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounter();
        try {
            wordCounter.loadStopWords();
        } catch (IOException ioException) {
            System.err.println("Error loading stop words: " + ioException.getMessage());
            return;
        }

        String text = "";

        if (args.length > 0) {
            FileReaderUtil fileReaderUtil = new FileReaderUtil(args[0]);
            try {
                text = fileReaderUtil.readLineByLine();
                wordCounter.countWords(text);
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Number of words: " + 0);
            }
        }
        // No filename provided, ask for text input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        text = scanner.nextLine();
        try {
            wordCounter.countWords(text);
        } catch (IllegalArgumentException e) {
            System.out.println("Number of words: " + 0);
        }
    }

}
