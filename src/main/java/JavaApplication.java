import java.util.Scanner;

public class JavaApplication {


    public static void main(String[] args) {

        WordCounter wordCounter = new WordCounter();

        if (args.length == 1) {
            String filename = args[0];
            Counter counter = wordCounter.countWordsFromFile(filename);
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
