package services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

    /**
     * Read the text from a file.
     *
     * @param filename the name of the file to read
     * @return the text read from the file
     */
    public String readWordsFromFile(String filename) {
        try {
            Path filePath = Path.of(filename);
            return Files.readString(filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return "";
    }
}
