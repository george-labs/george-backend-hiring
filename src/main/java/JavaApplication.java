import java.util.Scanner;
import java.util.Set;

public class JavaApplication {


    public static void main(String[] args) {

        Set<String> stopWords = ReadFileAdapter.getStopWords();
        WordCounter wordCounter = new WordCounter(stopWords);


        if (args.length == 1) {
            String filename = args[0];
            String text = ReadFileAdapter.loadTextFromFile(filename);
            Counter counter = wordCounter.countWords(text);
            System.out.println(getOutputMessage(counter));
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");

        String someText = scanner.nextLine();

        Counter counter = wordCounter.countWords(someText);
        System.out.println(getOutputMessage(counter));

    }

    private static String getOutputMessage(Counter counter) {
        String message = "Number of words: " + counter.getCount() + ", unique: " + counter.getCountUnique() +
                "; average word length: " + counter.getAverageLength() + " characters" +
                "\nIndex:\n";
        String usedWords = String.join("\n", counter.getUsedWords());

        return message + usedWords;
    }
}
