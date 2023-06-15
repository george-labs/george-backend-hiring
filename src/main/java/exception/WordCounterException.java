package exception;

public class WordCounterException extends RuntimeException {
    public WordCounterException(String message, Exception e) {
        super(message, e);
    }
}
