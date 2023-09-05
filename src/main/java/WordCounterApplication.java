import java.util.Scanner;

public class WordCounterApplication {

    private static final String ENTER_TEXT = "Enter text: ";
    private static final String NUMBER_OF_WORDS = "Number of words: ";

    public static void main(String[] args) {
        final Scanner inputScanner = new Scanner(System.in);

        System.out.print(ENTER_TEXT);

        final String userInput = inputScanner.nextLine();

        inputScanner.close();
    }

}
