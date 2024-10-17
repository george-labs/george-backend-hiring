import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WordCount {


    public Integer countNumbers() {
        System.out.print("Enter text:");
        Scanner scanner = new Scanner(InputStream.nullInputStream());
        String input = scanner.nextLine();

        if (isInputCorrect(input)) {
            return countResults(input);
        }

        return 0;
    }

    public Boolean isInputCorrect(String input) {
        if (input.isBlank()) {
            System.out.println("Input is empty");
            return false;
        }
        return true;
    }

    public Integer countResults(String inputString) {
        return Arrays.stream(inputString.split("([a-zA-Z])\\s")).toList().size();
    }
}
