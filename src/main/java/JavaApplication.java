import java.util.Scanner;

public class JavaApplication {
    // Create a Scanner object to read input from the command line
    Scanner scanner = new Scanner(System.in);

    // Prompt the user for input
    System.out.print("Enter something: ");

    // Read a line of input from the user
    String userInput = scanner.nextLine();

    //split according spaces
    String[] crudeWords = userInput.split("\\s+");
    //filterout letter words only


    // Print the user input
        System.out.println("You entered: " + userInput);

    // Close the scanner
        scanner.close();
}
