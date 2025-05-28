import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter text: ");
        String inputText = scanner.nextLine();

        Path stopWordsFile = Paths.get("stopwords.txt");
        var stopWordsService = new StopWordsService();
        var stopWords = stopWordsService.getStopWords(stopWordsFile);

        var wordCountingService = new WordCountingService();
        var wordCount = wordCountingService.countWords(inputText, stopWords);

        System.out.println("Number of words: " + wordCount);
    }

}
