package bootstrap;

import counter.WordCounter;
import handler.InputHandler;

import java.io.IOException;

public class Bootstrap {
    private final WordCounter wordCounter;
    private final InputHandler inputHandler;

    public Bootstrap(WordCounter wordCounter, InputHandler inputHandler) {
        this.wordCounter = wordCounter;
        this.inputHandler = inputHandler;
    }

    public int count() throws IOException {
        return wordCounter.count(inputHandler.handle());
    }
}
