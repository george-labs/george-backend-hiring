package application.infrastructure.input;

import static application.infrastructure.InfrastructureConstants.CONSOLE_INPUT_TEXT;

public class InputFactory {

    public String getInput(final String fileName) {
        final Input input;
        if (fileName.isEmpty()) {
            input = new ScannerInput(CONSOLE_INPUT_TEXT);
        } else {
            input = new FileInput(fileName);
        }

        return input.getInput();
    }
}
