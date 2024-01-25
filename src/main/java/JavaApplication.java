import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class JavaApplication {

    private static Pattern PATTERN = Pattern.compile("^[a-zA-Z]*$");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        if (in.isEmpty()) {
            System.out.println("not a valid string");
            System.exit(-1);
        }
        String[] split = in.split(" ");
        System.out.println("Enter text: ");
        long count = Arrays.stream(split)
                .filter(s -> PATTERN.matcher(s).matches())
                .count();

        System.out.println("Number of Words:" + count);

    }
}
