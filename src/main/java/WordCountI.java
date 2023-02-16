import java.util.Scanner;

public class WordCountI {

    public int wordCountI() {
        String input = getInput();

        //Validate the input
        validateInput(input);

        //Slice the string by space
        int wordCount = input.split(" ").length;

        //Output the length
        System.out.println("Number of words: " + wordCount);
        return wordCount;
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
