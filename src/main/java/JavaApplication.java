import java.util.Scanner;

public class JavaApplication {


    public static void main(String[] args) {

        WordCounter wordCounter = new WordCounter();

        if (args.length == 1) {
            String filename = args[0];
            long wordsInFile = wordCounter.countWordsFromFile(filename);
            System.out.print("Number of words: " + wordsInFile);
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");

        String someText = scanner.nextLine();

        long numberOfWords = wordCounter.countWords(someText);
        System.out.print("Number of words: " + numberOfWords);

    }
}
