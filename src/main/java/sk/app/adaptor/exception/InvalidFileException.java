package sk.app.adaptor.exception;

import java.io.IOException;

public class InvalidFileException extends RuntimeException {

	public InvalidFileException(IOException exception) {
		super(exception);
	}
}
