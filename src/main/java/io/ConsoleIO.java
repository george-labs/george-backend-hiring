package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConsoleIO implements IO {

    private final BufferedReader bufferedReader;

    public ConsoleIO(InputStream inputStream) {
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

    @Override
    public void print(String text) {
        System.out.print(text);
    }

    @Override
    public void println(String text) {
        System.out.println(text);
    }
}
