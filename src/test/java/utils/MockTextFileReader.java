package utils;

public class MockTextFileReader extends TextFileReader {

    private final String defaultText;

    public MockTextFileReader(String defaultText) {
        this.defaultText = defaultText;
    }

    @Override
    public String readFile(String fileName) {
        return defaultText;
    }
}
