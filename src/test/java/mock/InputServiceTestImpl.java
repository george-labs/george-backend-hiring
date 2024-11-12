package mock;

import service.InputService;

public class InputServiceTestImpl implements InputService {
    @Override
    public String getInput() {
        return "This is first iteration test";
    }
}
