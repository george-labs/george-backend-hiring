package app.mocks;

import java.io.IOException;

import input.InputReader;

public class InputReaderMock implements InputReader {

    @Override
    public String readLine() {
        return "Marry had a little lamb";
    }

}
