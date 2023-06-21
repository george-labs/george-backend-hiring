import service.ReaderService;
import service.WordService;

import java.util.List;

public class JavaApplication {

    public static void main(String... args) {
        System.out.print("Enter text: ");

        List<String> wordsNotToCount = ReaderService.readFromFile("stopwords.txt");
        String inputString = ReaderService.readFromConsole();
        int wordCount = WordService.countWords(inputString, wordsNotToCount);

        System.out.println("Number of words: " + wordCount);
    }

}
