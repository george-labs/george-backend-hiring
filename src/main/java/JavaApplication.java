import java.util.List;
import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args) {
        String input = "";
        FileReader fileReader = new FileReader();

        if (args.length == 0) {
            input = readFromInput();
        } else {
            fileReader.readFileFromArguments(args[0]);
        }

        List<String> forbiddenWords = fileReader.readWordsFromFile("src/main/resources/stopwords.txt");

        WordCounter wordCounter = new WordCounter(input, forbiddenWords);
        System.out.println("Number of words: " + wordCounter.countWords());
    }

    private static String readFromInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");

        return sc.nextLine();
    }
}
