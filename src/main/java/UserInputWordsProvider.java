import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInputWordsProvider implements WordsProvider {

    @Override
    public List<String> provideWords() {
        return splitWords(readCommandLineWords());
    }

    private String readCommandLineWords() {
        // Create a Scanner object to read input from the command line
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter text: ");

        // Read a line of input from the user
        String userInput = scanner.nextLine();

        // Close the scanner
        scanner.close();

        return userInput;
    }

    private List<String> splitWords(String input) {
        //split according spaces
        return Arrays.stream(input.split("\\s+")).toList();
    }
}
