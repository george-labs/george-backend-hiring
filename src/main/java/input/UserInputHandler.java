package input;

import java.io.InputStream;
import java.util.Scanner;

public class UserInputHandler {
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
