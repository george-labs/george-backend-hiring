import service.ReaderService;
import service.WordService;

import java.util.List;

public class JavaApplication {

    public static void main(String... args) {
        ReaderService readerService = new ReaderService();
        WordService wordService = new WordService();

        List<String> wordsNotToCount = readerService.read("stopwords.txt");
        String inputFileName = args.length == 0 ? "" : args[0];
        List<String> inputString = readerService.read(inputFileName);
        int wordCount = wordService.countWords(inputString, wordsNotToCount);

        System.out.println("Number of words: " + wordCount);
    }

}