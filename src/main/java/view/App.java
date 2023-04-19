package view;

import java.io.PrintStream;
import java.util.Scanner;

public class App {

    private final Scanner inputStream;
    private final CountService countService;
    private final PrintStream outputStream;

    public App(Scanner inputStream, CountService countService, PrintStream outputStream) {
        this.inputStream = inputStream;
        this.countService = countService;
        this.outputStream = outputStream;

    }

    public void application() {
        outputStream.print("Enter text: ");
        String input = inputStream.nextLine();
        int wordCount = countService.getWordsCount(input);
        outputStream.println("Number of words: " + wordCount);
    }


}
