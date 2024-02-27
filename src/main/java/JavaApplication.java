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
                System.out.println("Number of words: " + wordCounter.countWords(text));
                return;
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        }
            // No filename provided, ask for text input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter text: ");
            text = scanner.nextLine();


        int count = wordCounter.countWords(text);
        System.out.println("Number of words: " + count);
    }

}
