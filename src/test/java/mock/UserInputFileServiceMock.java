package mock;

import service.InputService;

public class UserInputFileServiceMock implements InputService {
    @Override
    public String getInput() {
        return "This is 1st integration test";
    }
}
