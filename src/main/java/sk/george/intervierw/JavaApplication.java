package sk.george.intervierw;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaApplication {
    private static final Logger LOGGER = Logger.getLogger(JavaApplication.class.getName());
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your input:");
        String userInput = scanner.nextLine();

        // Process the input string here
        LOGGER.log(Level.INFO, "You entered: " + userInput);
    }
}
