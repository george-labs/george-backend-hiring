package exception;

import exception.WordCounterException;

public class BlackListException extends WordCounterException {

    public BlackListException(String message) {
        super(message);
    }

    public BlackListException(String message, Throwable cause) {
        super(message, cause);
    }
}
