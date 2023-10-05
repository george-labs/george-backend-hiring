package handler;

import io.IO;

import java.io.IOException;

public class ConsoleHandler implements Handler {

    private final IO io;

    public ConsoleHandler(IO io) {
        this.io = io;
    }

    @Override
    public String handle() throws IOException {
        System.out.print("Enter text: ");
        return io.read();
    }
}
