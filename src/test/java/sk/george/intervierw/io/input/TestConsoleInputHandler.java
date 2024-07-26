package sk.george.intervierw.io.input;

import java.util.List;

import sk.george.intervierw.exception.NonRecoverableException;

public class TestConsoleInputHandler implements InputHandler {
    private final String mockInput;
    public TestConsoleInputHandler(String mockInput) {
        this.mockInput = mockInput;
    }

    @Override
    public String loadSingle(String path) throws NonRecoverableException {
        return mockInput;
    }

    @Override
    public List<String> loadMultiple(String path) throws NonRecoverableException {
        return List.of(mockInput);
    }
}
