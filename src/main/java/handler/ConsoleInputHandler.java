package handler;

import io.InputOutput;

import java.io.IOException;

public class ConsoleInputHandler implements InputHandler {

    private final InputOutput inputOutput;

    public ConsoleInputHandler(InputOutput inputOutput) {
        this.inputOutput = inputOutput;
    }

    @Override
    public String handle() throws IOException {
        System.out.print("Enter text: ");
        return inputOutput.read();
    }
}
