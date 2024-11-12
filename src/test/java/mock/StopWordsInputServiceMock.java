package mock;

import service.InputService;

public class StopWordsInputServiceMock implements InputService {
    @Override
    public String getInput() {
        return """
                the
                is
                on
                off""";
    }
}
