import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCount {


    public void countNumbers() {
        System.out.print("Enter text:");
        Scanner scanner = new Scanner(InputStream.nullInputStream());
        String input = scanner.nextLine();

        if (isInputCorrect(input)) {
            System.out.println("Number of words:" + countResults(readUserInput(input)));
        }

    }

    private Boolean isInputCorrect(String input) {
        if (input.isBlank()) {
            System.out.println("Input is empty");
            return false;
        }
        return true;
    }

    private String[] readUserInput(String input) {
        return input.split("\\s+");
    }

    private Integer countResults(String[] inputArray) {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        return Arrays.stream(inputArray).filter(pattern.asPredicate()).toList().size();
    }
}
