import java.util.Scanner;

public class JavaApplication {


    public static void main(String[] args) {

        WordCounter wordCounter = new WordCounter();

        if (args.length == 1) {
            String filename = args[0];
            Counter counter = wordCounter.countWordsFromFile(filename);
            System.out.println("Number of words: " + counter.getCount() + ", unique: " + counter.getCountUnique() +
                    "; average word length: " + counter.getAverageLength() + " characters");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");

        String someText = scanner.nextLine();

        Counter counter = wordCounter.countWords(someText);
        System.out.println("Number of words: " + counter.getCount() + ", unique: " + counter.getCountUnique() +
                "; average word length: " + counter.getAverageLength() + " characters");

    }
}
