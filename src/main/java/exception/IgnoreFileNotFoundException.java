package exception;

public class IgnoreFileNotFoundException extends RuntimeException {

  public IgnoreFileNotFoundException(final String path) {
    super("File for words to ignore is not found for path: " + path);
  }
}
