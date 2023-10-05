package handler;

import io.IO;

import java.io.IOException;

public class FileHandler implements Handler {
    private final IO io;

    public FileHandler(IO io) {
        this.io = io;
    }

    @Override
    public String handle() throws IOException {
        return io.read();
    }
}