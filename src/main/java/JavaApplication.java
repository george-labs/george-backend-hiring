import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {

        String fileName;
        List<String> input;

        try {
            if (args.length > 0) {
                fileName = args[0];
                input = FileLoader.loadInputContent(fileName);
            } else {
                System.out.println("Enter text: ");
                Scanner scanner = new Scanner(System.in);

                input = new ArrayList<>();
                input.add(scanner.nextLine());

                scanner.close();
            }

            var stopWords = FileLoader.loadStopWords();
            var wordCounter = new WordCounter(input, stopWords);

            wordCounter.countWords();
            var wordCount = wordCounter.getWordCount();

            System.out.println("Number of words: " + wordCount);
        } catch (IOException e) {
            System.err.println("Encountered an error: " + e.getMessage());
        }
    }

}
