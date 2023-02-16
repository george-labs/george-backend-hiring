import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class WordCountI {

    private static Set<String> stopWords = Set.of("the", "a", "on", "off");

    public int wordCountI() {
        String input = getInput();

        //Validate the input
        validateInput(input);

        //Slice the string by space
        String[] split = input.split(" ");

        List<String> wordCountWithoutStopWords = Arrays.stream(split)
                .filter(word -> !stopWords.contains(word))
                .collect(Collectors.toList());

        //Output the length
        System.out.println("Number of words: " + wordCountWithoutStopWords.size());
        return wordCountWithoutStopWords.size();
    }

    private String getInput() {
        //Get a sentence from the user
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter text: ");

        return myObj.nextLine();
    }

    private void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new RuntimeException("The input string is blank!");
        }

        boolean valid = input.matches("[a-zA-Z ]+");
        if (!valid) {
            throw new RuntimeException("The input string contains invalid character(s)!");
        }
    }

}
