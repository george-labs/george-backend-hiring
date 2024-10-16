package service.mocks;

import input.InputReader;

public class InputReaderMock implements InputReader {

    private  String inputString;

    public InputReaderMock(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String read() {
        return inputString;
    }

}
