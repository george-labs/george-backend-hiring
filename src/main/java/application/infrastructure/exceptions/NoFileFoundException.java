package application.infrastructure.exceptions;

public class NoFileFoundException extends RuntimeException {
    public NoFileFoundException(final String message) {
        super(message);
    }
}
