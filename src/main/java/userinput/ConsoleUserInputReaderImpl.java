package userinput;

import java.util.Scanner;

public class ConsoleUserInputReaderImpl implements UserInputReader {

    private static final String ENTER_TEXT = "Enter text: ";

    @Override
    public String getUserInput() {
        return readUserInputFromConsole();
    }

    private static String readUserInputFromConsole() {
        final Scanner inputScanner = new Scanner(System.in);

        System.out.print(ENTER_TEXT);

        final String userInput = inputScanner.nextLine();

        inputScanner.close();

        return userInput;
    }

}
