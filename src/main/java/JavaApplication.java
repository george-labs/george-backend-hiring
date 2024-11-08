import java.util.Scanner;

public class JavaApplication {


    public static void main(String[] args) {
        // Create a Scanner object to read input from the command line
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter text: ");

        // Read a line of input from the user
        String userInput = scanner.nextLine();

        // Print the user input
        System.out.println("Number of words: " + new WordCounter(userInput).countWords());

        // Close the scanner
        scanner.close();
    }
}
