package handler;

import io.InputOutput;

import java.io.IOException;

public class FileInputHandler implements InputHandler {
    private final InputOutput inputOutput;

    public FileInputHandler(InputOutput inputOutput) {
        this.inputOutput = inputOutput;
    }

    @Override
    public String handle() throws IOException {
        return inputOutput.read();
    }
}