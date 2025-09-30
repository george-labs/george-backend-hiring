import java.util.Scanner;

public class JavaApplication {

    private static final String ENTER_TEXT = "Enter text: ";
    private static final String NUMBER_OF_WORDS = "Number of words: ";
    private static final String SPACE = " ";

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print(ENTER_TEXT);

        final String text = scanner.nextLine();
        final int wordCount = countWords(text);

        System.out.println(NUMBER_OF_WORDS + wordCount);
    }

    private static int countWords(final String text) {
        return text.split(SPACE).length;
    }

}
