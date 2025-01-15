package exception;

public class NullInputException extends RuntimeException {

  public NullInputException() {
    super("Received a null as an input string!");
  }
}
