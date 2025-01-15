package exception;

public class RequiredFileNotFoundException extends RuntimeException {

  public RequiredFileNotFoundException(final String path) {
    super("File required for processing not found for path: " + path);
  }
}
