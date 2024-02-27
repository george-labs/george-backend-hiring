import counter.WordCounter;
import util.FileReaderUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) throws FileNotFoundException {
        WordCounter wordCounter = new WordCounter();
        String text;
        try {
            wordCounter.loadStopWords();
        } catch (final IOException ioException) {
            throw new IllegalArgumentException(String.format("Path is not found"));
        }
        final String fileName = args[0];
        FileReaderUtil fileReaderUtil = new FileReaderUtil(fileName);
        try {
            text = fileReaderUtil.readLineByLine();
        } catch (IOException e) {
            throw new IllegalArgumentException("pathname is invalid");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        text = scanner.nextLine();
        int count = wordCounter.countWords(text);
        System.out.println("Number of words: " + count);
    }

}
