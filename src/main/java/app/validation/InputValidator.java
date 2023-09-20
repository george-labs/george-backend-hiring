package app.validation;

import static java.util.Objects.isNull;

public class InputValidator {

    public void validateInputLine(String line) {
        if (isNull(line) || line.isEmpty()) {
            throw new WordCountValidationException("Input string cannot be null or empty");
        }
    }

}
