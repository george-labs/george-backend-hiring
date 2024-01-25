import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WordCounter {

    private static final Pattern PATTERN = Pattern.compile("^[a-zA-Z]*$");

    public static String readFromSystemIn() {
        String in = null;
        try (Scanner scanner = new Scanner(System.in)) {
            in = scanner.nextLine();
            if (in.isEmpty()) {
                System.out.println("not a valid string");
                System.exit(-1);
            }
        }
        return in;
    }

    public static long countWords(String in) {
        if(in == null || in.isEmpty()) {
            return 0;
        }
        String[] split = in.split(" ");

        return Arrays.stream(split)
                .filter(s -> PATTERN.matcher(s).matches())
                .count();
    }
}
