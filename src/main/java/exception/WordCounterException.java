package exception;

public class WordCounterException extends RuntimeException {

    public WordCounterException(String message) {
        super(message);
    }

    public WordCounterException(String message, Throwable cause) {
        super(message, cause);
    }
}
