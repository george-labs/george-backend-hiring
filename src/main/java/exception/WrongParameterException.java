package exception;

import java.io.IOException;

public class WrongParameterException extends IOException {

    public WrongParameterException(String message) {
        super(message);
    }
}
