import service.ReaderService;
import service.WordService;

import java.util.List;

public class JavaApplication {

    public static void main(String... args) {
        System.out.print("Enter text: ");

        List<String> wordsNotToCount = ReaderService.readFromFile("stopwords.txt");
        String inputFileName = ReaderService.readFromConsole();
        List<String> inputString = ReaderService.readFromFile(inputFileName);
        String concatenatedInputString = String.join(" ", inputString);

        int wordCount = WordService.countWords(concatenatedInputString, wordsNotToCount);

        System.out.println("Number of words: " + wordCount);
    }

}
