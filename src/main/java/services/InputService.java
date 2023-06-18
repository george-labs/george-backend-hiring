package services;

import java.util.Scanner;

/**
 * The InputService class provides a method to read text input from the user.
 */
public class InputService {
    private final Scanner scanner;

    /**
     * Constructs an InputService object.
     */
    public InputService() {
        scanner = new Scanner(System.in);
    }

    /**
     * Read the text input from the user
     *
     * @return the text entered by the user
     */
    public String readWords() {
        System.out.print("Enter text:");

        return scanner.nextLine();
    }

    /**
     * Closes the Scanner instance.
     */
    public void close() {
        scanner.close();
    }
}
