import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaApplication {
    public static void main(String[] args) {
        // Read stdin
        System.out.print("Enter text: ");

        Scanner input = new Scanner(System.in);

        String line = input.nextLine();

        Pattern pattern = Pattern.compile("[^a-zA-Z]+");
        Matcher matcher = pattern.matcher(line);

        long count = matcher.results().count();
        System.out.println("Number of words: " + count);

        input.close();
    }
}
