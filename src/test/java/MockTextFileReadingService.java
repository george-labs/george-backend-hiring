public class MockTextFileReadingService extends TextFileReadingService {

    private final String defaultText;

    public MockTextFileReadingService(String defaultText) {
        this.defaultText = defaultText;
    }

    @Override
    public String readFile(String fileName) {
        return defaultText;
    }
}
