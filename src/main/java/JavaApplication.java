import util.FileReader;
import util.PrintResult;

import java.util.List;
import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        List<String> stopWords = fileReader.readWordsFromFile("src/main/resources/stopwords.txt");

        WordCounter wordCounter = new WordCounter(getInput(args, fileReader), stopWords);
        PrintResult result = wordCounter.count();

        System.out.print(result);
    }

    private static String getInput(String[] args, FileReader fileReader) {
        if (args.length == 0) {
            return readFromInput();
        } else {
            return fileReader.readWordsFromFileAsString(args[0]);
        }
    }

    private static String readFromInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");

        return sc.nextLine();
    }
}
