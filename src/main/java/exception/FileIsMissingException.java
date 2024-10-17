package exception;

import java.io.FileNotFoundException;

public class FileIsMissingException extends RuntimeException {


    public FileIsMissingException(String e) {
        super(e);
    }
}
