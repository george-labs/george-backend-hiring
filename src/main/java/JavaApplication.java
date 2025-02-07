import java.util.Scanner;

public class JavaApplication {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter text: ");
        String s1 = SCANNER.nextLine();
        System.out.printf("Number of words: %d%n", countWords(s1));
    }

    private static int countWords(String inputLine) {

        var splitedString = inputLine.split(" ");

        return 0;
    }
}
