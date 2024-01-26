import java.util.Arrays;
import java.util.Scanner;


public class JavaApplication {

    public static void main(String... args) {
        System.out.println("Enter text:");
        Scanner scanner = new Scanner(System.in);
        var input = scanner.nextLine();
        System.out.println("Number of words: " + countWord(input));
    }

    public static long countWord(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }
        return Arrays.stream(input.split(" ")).filter(s -> s.matches("[a-zA-Z]+\\.?")).count();
    }
}
