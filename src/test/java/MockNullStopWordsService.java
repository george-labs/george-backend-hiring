import service.StopWordsService;

import java.util.Collections;
import java.util.Set;

public class MockNullStopWordsService extends StopWordsService {

    public MockNullStopWordsService() {
        super(new MockTextFileReader(""));
    }

    @Override
    public Set<String> getStopWords(String stopWordsFile) {
        return null;
    }
}
