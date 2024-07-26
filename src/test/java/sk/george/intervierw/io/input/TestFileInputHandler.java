package sk.george.intervierw.io.input;

import java.util.List;
import java.util.Objects;

import sk.george.intervierw.exception.NonRecoverableException;

public class TestFileInputHandler implements InputHandler {

    private final List<String> mockInputs;

    public TestFileInputHandler(List<String> mockInputs) {
        this.mockInputs = mockInputs;
    }

    @Override
    public String loadSingle(String path) throws NonRecoverableException {
        return Objects.nonNull(mockInputs) ? mockInputs.getFirst() : null;
    }

    @Override
    public List<String> loadMultiple(String path) throws NonRecoverableException {
        return mockInputs;
    }
}
