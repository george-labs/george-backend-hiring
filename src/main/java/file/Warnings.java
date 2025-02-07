package file;

public enum Warnings {
    STOP_WORDS_FILE_NOT_FOUND("Warning: The system cannot find the file containing stop words"),
    USER_INPUT_FILE_NOT_FOUND("Warning: The system cannot find the file containing user input"),
    UNEXPECTED_PROGRAM_ARGUMENTS("Warning: program was launched with more than 1 args");

    private final String errorMessage;

    Warnings(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
