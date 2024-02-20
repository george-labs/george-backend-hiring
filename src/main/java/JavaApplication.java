import java.util.Scanner;

public class JavaApplication {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");

        String someText = scanner.nextLine();

        WordCounter wordCounter = new WordCounter();
        long numberOfWords = wordCounter.countWords(someText);
        System.out.print("Number of words: " + numberOfWords);

    }
}
