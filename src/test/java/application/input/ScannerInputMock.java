package application.input;

import application.infrastructure.input.Input;

public class ScannerInputMock implements Input {
    private static final String DUMMY_TEXT = "I hate console input";
    @Override
    public String getInput() {
        return DUMMY_TEXT;
    }
}
