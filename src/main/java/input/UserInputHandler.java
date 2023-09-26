package input;

import java.io.InputStream;
import java.util.Scanner;

public class UserInputHandler {
    private final InputStream inputStream;

    public UserInputHandler(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String readUserInput(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        var scanner = new Scanner(inputStream);
        String userInput = null;
        if (scanner.hasNext()) {
            userInput = scanner.nextLine();
        }
        scanner.close();
        return userInput;
    }
}
