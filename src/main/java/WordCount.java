import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordCount {


    public Integer countNumbers() {
        System.out.print("Enter text:");
        Scanner scanner = new Scanner(InputStream.nullInputStream());
        String input = scanner.nextLine();

        return isInputCorrect(input) ? countResults(input) : Integer.valueOf(0);
    }

    public Boolean isInputCorrect(String input) {
        if (input.isBlank()) {
            System.out.println("Input is empty");
            return false;
        }
        return true;
    }

    public Integer countResults(String inputString) {

        List<String> splitList = Arrays.stream(inputString.split("\\s")).toList();
        return splitList.stream().filter(item -> item.matches("[a-zA-Z]+")).toList().size();


    }
}
