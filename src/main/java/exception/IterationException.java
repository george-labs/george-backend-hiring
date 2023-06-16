package exception;

public class IterationException extends Exception {
    public IterationException() {
        super();
    }

    public IterationException(String message) {
        super(message);
    }

    public IterationException(String message, Throwable cause) {
        super(message, cause);
    }
}
