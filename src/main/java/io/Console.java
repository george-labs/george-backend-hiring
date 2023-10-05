package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Console implements InputOutput {

    private final BufferedReader bufferedReader;

    public Console(InputStream inputStream) {
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    @Override
    public String read() throws IOException {
        String input = bufferedReader.readLine();

        if (input == null) {
            return "";
        }

        return input;
    }
}
