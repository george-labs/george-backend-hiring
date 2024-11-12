package mock;

import service.InputService;

public class UserInputServiceMock implements InputService {
    @Override
    public String getInput() {
        return "This is first iteration test";
    }
}
