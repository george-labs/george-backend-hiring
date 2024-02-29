import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JavaApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text:");
        String line = scanner.nextLine();

        Pattern pattern = Pattern.compile("[a-zA-Z]");

        List<String> items = Arrays.stream(line.split("\\w")).filter(w -> {
            Matcher matcher = pattern.matcher(w);
            return matcher.find();
        }).collect(Collectors.toList());

        System.out.println("Number of words:" + items.size());
    }
}
