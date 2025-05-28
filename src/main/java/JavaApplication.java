import service.StopWordsService;
import service.WordCountingService;
import utils.TextFileReader;

import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {

        String inputText = "";
        TextFileReader textFileReader = new TextFileReader();
        boolean printIndex = args.length > 0 && args[0].startsWith("-index");

        if (args.length > 0 && !args[0].startsWith("-")) {
           String filename = args[0];
           inputText = textFileReader.readFile(filename);
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter text: ");
            inputText = scanner.nextLine();
        }

        var wordCountingService = new WordCountingService(new StopWordsService(textFileReader));
        var wordCount = wordCountingService.countWords(inputText);

        System.out.println("Number of words: " + wordCount);
        if (printIndex) {
            System.out.println("Index:");
            wordCount.uniqueWords().forEach(System.out::println);
        }
    }

}
