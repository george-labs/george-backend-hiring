import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {

        String inputText;
        TextFileReadingService textFileReadingService = new TextFileReadingService();

        if (args.length > 0) {
            String filename = args[0];
            inputText = textFileReadingService.readFile(filename);
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter text: ");
            inputText = scanner.nextLine();
        }

        String stopWordsFile = "src/main/resources/stopwords.txt";
        var stopWordsService = new StopWordsService(textFileReadingService);
        var stopWords = stopWordsService.getStopWords(stopWordsFile);

        var wordCountingService = new WordCountingService();
        var wordCount = wordCountingService.countWords(inputText, stopWords);

        System.out.println("Number of words: " + wordCount);
    }

}
