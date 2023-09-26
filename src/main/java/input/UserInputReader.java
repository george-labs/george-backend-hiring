package input;

import java.io.InputStream;
import java.util.Scanner;

public class UserInputReader implements InputReader {
    private final InputStream inputStream;

    public UserInputReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getInputText() {
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
