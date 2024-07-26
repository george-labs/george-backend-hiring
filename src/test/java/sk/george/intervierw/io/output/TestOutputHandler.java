package sk.george.intervierw.io.output;

import java.util.ArrayList;
import java.util.List;

public class TestOutputHandler implements OutputHandler {
    private final List<String> messages = new ArrayList<>();
    @Override
    public void print(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }
}
