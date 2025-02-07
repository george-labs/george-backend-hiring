import java.util.Arrays;
import java.util.Scanner;

public class JavaApplication {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter text: ");
        String s1 = SCANNER.nextLine();
        System.out.printf("Number of words: %d%n", countWords(s1));
    }

    protected static long countWords(String inputLine) {
        if (inputLine == null || inputLine.isEmpty()) {
            return 0;
        }

        var splitedString = inputLine.split(Constants.DELIMETER);

        return Arrays.stream(splitedString)
                .filter(substr -> substr.matches(Constants.PATTERN))
                .count();
    }
}
