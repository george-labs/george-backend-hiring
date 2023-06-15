import java.util.List;
import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args) {
        String input;
        FileReader fileReader = new FileReader();

        if (args.length == 0) {
            input = readFromInput();
        } else {
            input = fileReader.readWordsFromFileAsString(args[0]);
        }

        List<String> forbiddenWords = fileReader.readWordsFromFile("src/main/resources/stopwords.txt");

        WordCounter wordCounter = new WordCounter(input, forbiddenWords);
        System.out.print("Number of words: " + wordCounter.countWords() + ", unique: " + wordCounter.countUniqueWords());
    }

    private static String readFromInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");

        return sc.nextLine();
    }
}
