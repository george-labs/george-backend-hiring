package stopwords;

import exception.WordCounterException;

public class StopWordsException extends WordCounterException {

    public StopWordsException(String message) {
        super(message);
    }

    public StopWordsException(String message, Throwable cause) {
        super(message, cause);
    }
}
